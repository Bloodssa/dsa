package java_dsa_leetcode.array_string_hashing;

import java.util.Arrays;

public class ProductOfArrayItSelf {
    public static void main(String[] args){
        int[] nums = {1,2,3,4};

        var res = ProductItSelf.productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }
}

class ProductItSelf
{
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];
        int[] pref = new int[n];
        int[] suf = new int[n];

        pref[0] = 1;
        suf[n - 1] = 1;
        for(int i = 1; i < n; i++) {
            pref[i] = nums[i - 1] * pref[i -1];
        }

        for(int i = n-2; i >= 0; i--) {
            suf[i] = nums[i + 1] * suf[i+1];
        }

        for(int i = 0; i < n; i++) {
            product[i] = pref[i] * suf[i];
        }
        // System.out.println("Preffix: " + Arrays.toString(pref));
        // System.out.println("Suffix: " + Arrays.toString(suf));

        return product; 
    }

    /**
     * ERROR: Time Limit Exceeded IN LEETCODE TEST CASE 19
     * [-1,-1,1,-1,-1,-1,1,-1,1......................................................]
     */
    public static int[] bruteForce(int[] nums) {
        int n = nums.length;
        int[] product = new int[n];

        for(int i = 0; i < n; i++) {
            int prod = 1;
            for(int j =0; j < n; j++) {
                if(i != j) {
                    prod *= nums[j]; 
                }
            }
            product[i] = prod;
        }
        return product;
    }
}