// LEETCODE: 283. Move Zeroes
import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] a){
        int[] nums = {1, 0};

        MoveZero.moveZeroes(nums);

        System.out.println("Zeroes Move: " + Arrays.toString(nums));
    }
}

class MoveZero
{
    public static void moveZeroes(int[] nums) {
        // Start with index 0
        int l = 0;

        /**
         * The r pointer will find a element with 0 values
         * If the r find zero val then swap it to the l pointer
         * put the non zero element found with the r pointer to the place of the l pointer
         * Then increment the increment the l pointer to move the pointer
         */
        for(int r = 0; r < nums.length; r++){
            if(nums[r] != 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
        }
    }
}