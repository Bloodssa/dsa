package java_dsa_leetcode.sliding_window;
import java.util.*;

public class LongStrWithRepeatingChar {
    public static void main(String[] args){
        String s = "pwwkew";

        int res = LongStrLength.lengthOfLongestSubstring(s);

        System.out.println(res);
    }
}
 
class LongStrLength
{
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int l = 0;

        for(int r = 0; r < s.length(); r++) {
            while(set.contains(s.charAt(r))){ // if the char at index r is already in the set then move l to the r and remove all l element inside the set
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxLength = Math.max(maxLength, r-l + 1);
        }

        return maxLength;
    }
}