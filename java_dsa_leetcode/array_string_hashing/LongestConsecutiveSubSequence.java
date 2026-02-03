package java_dsa_leetcode.array_string_hashing;

import java.util.*;

public class LongestConsecutiveSubSequence {
    public static void main(String[] args) {
        int[] nums = {2,20,4,10,3,4,5};
        var res = LengthSubSequence.longestConsecutive(nums);

        System.out.println(res);
    }
}

class LengthSubSequence {
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();

        // System.out.println(Arrays.toString(nums));

        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 1;
        int curLength = 1;

        List<Integer> list = new ArrayList<>(set);

        Collections.sort(list);

        // System.out.println(list);
        for (int i = 0; i < list.size() - 1; i++) {
            Integer cur = list.get(i);
            Integer next = list.get(i + 1);

            if (cur == next - 1) {
                curLength++;
            }else{
                maxLength = Math.max(maxLength, curLength);
                curLength = 1;
            }
        }

        return Math.max(maxLength, curLength);
    }
}
