package java_dsa_leetcode.array_string_hashing;
import java.util.*;

public class EncodeDecode {
    public static void main(String[] args){
        List<String> strs = Arrays.asList("neet","code","love","you");

        // System.out.println(strs);
        String res = EncodeDecodeSolution.encode(strs);
        System.out.println(res);

        List<String> decode = EncodeDecodeSolution.decode(res);
        System.out.println(decode);
    }
}

class EncodeDecodeSolution
{
    public static String encode(List<String> strs) 
    {
        StringBuilder sb = new StringBuilder();
        
        // The Delimeter is length of str and % ex. str = neet = 4%neet
        for(String str : strs) {
            sb.append(str.length()).append('%').append(str);
        }

        return sb.toString();
    }

    public static List<String> decode(String str) 
    {
        List<String> decode = new ArrayList<>();
        int i = 0;

        while(i < str.length()) {
            int delimeterIdx = str.indexOf('%', i);

            int lengthOfEveryStr = Integer.parseInt(str.substring(i, delimeterIdx)); // get the length of a string 4 like and covert it to int

            int startStr = delimeterIdx + 1;
            int endStr = startStr + lengthOfEveryStr;

            decode.add(str.substring(startStr, endStr));

            i = endStr;
        }
        return decode;
    }
}