// LEETCODE: 26. Remove Duplicates from Sorted Array
public class RemoveDuplicates {
    public static void main (String[] a){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int res = RemoveDup.removeDuplicates(nums);

        for(int i = 0; i < res; i++) {
            System.out.print(nums[i]);
        }
        System.out.println("Length: " + res);
    }
}

class RemoveDup
{
    public static int removeDuplicates(int[] nums) {
        // Start the left pointer at 0
        int l = 0;

        /**
         * Move the left pointer only if the right pointer is not equal to the left
         * Move the left pointer first, then copy the right pointer value 
         * Ex. 1, 1, 2
         *     l     r
         *     1  1  2
         *        l  r
         *  =  1  2  2
         */ 
        for (int r= 1; r < nums.length; r++) {
            if(nums[l] != nums[r]) {
                l++;
                nums[l] = nums[r];
            }
        }

        // return l + 1 since the left start in zero and will be increment if it only not the same element
        return l + 1;
    }
}

// TIME: O(N)
// SPACE: O(1)