package java_dsa_leetcode.array_string_hashing;
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> res = Group.groupAnagrams(strs);

        System.out.println(res);
    }
}

class Group
{
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);

            String s = new String(c); // convert back to string the char sorted as the key

            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(str); // add the str they have the same sorted key ot the str sorted based on chararray
        }

        return  new ArrayList<>(map.values());
    }
}