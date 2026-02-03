package java_dsa_leetcode.sliding_window;

public class MaximumAverageSubArr {
    public static void main(String[] args){
        int[] nums = {-1};
        int k = 1;

        double res = AvgSubArr.findMaxAverage(nums, k);

        System.out.println(res);

    }
}

class AvgSubArr
{
    public static double findMaxAverage(int[] nums, int k) {
        
        int maxAverage = 0;
        int sum = 0;

        // get the sum of the first k element
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        // Init maxAvg
        maxAverage = sum;

        // in this loop minus the leaving element in the sum then add the new element
        for(int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];

            maxAverage = Math.max(maxAverage, sum); // compare it to the last maxAvg
        }

        return (double) maxAverage / k;
    }
}