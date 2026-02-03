package java_dsa_leetcode.kadane;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        int res = Kadane.maxSubArray(nums);

        System.out.println(res);
    }
}

class Kadane {
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max + nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}