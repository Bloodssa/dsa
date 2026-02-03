package java_dsa_leetcode.binary_search;

public class FindPeakElement {
    public static void main(String[] args){
        int[] nums = {1,2,1,3,5,6,4};

        var res = PeakElement.findPeakElement(nums);
        System.out.println(res);
    }
}

class PeakElement
{
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // move left is less than to right stop when the loop when left and right pointers meet return left
        while(left < right) {
            if(nums[left] < nums[right]) {
                left++;
            }else {
                right--;
            }
        }

        return left;
    }
}