package java_dsa_leetcode.sliding_window;
import java.util.*;

public class ContainsDuplicateII {
    public static void main(String[] args){
        int[] nums = {1,2,3,1,2,3};
        int k = 2;

        var res = ContainsDup.containsNearbyDuplicate(nums, k);
        System.out.println(res);
    }
}


class ContainsDup
{
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return false;

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);


            // Remove the leaving element
            if(set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}

// TIME: O(N)
// SPACE: O(N * K)