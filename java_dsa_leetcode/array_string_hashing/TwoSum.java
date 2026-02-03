package java_dsa_leetcode.array_string_hashing;
import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int  target = 9;

        int[] res = Sum.twoSum(nums, target);

        System.out.println(Arrays.toString(res));
    }
}

class Sum 
{
    //TIME: O(N)
    //SPACE: O(N)
    public static int[] twoSum(int[] nums, int target) 
    {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if(map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(num, i);
        }

        return new int[]{};
    }
}



// TIME: O(N^2)
// SPACE: O(1)
class BrutrForce 
{
    public int[] twoSum(int[] nums, int target) 
    {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] + nums[j - i] == target) {
                    return new int[] { j, j - i };
                }
            }
        }
        return null;
    }
}