import java.util.Arrays;

public class SquaredOfSortedArr {
    public static void main(String[] args) {
        int[] nums = { -4, -1, 0, 3, 10 };

        int[] squaresOfNums = SquaredSorted.sortedSquares(nums);

        System.out.println(Arrays.toString(squaresOfNums));
    }
}

class SquaredSorted {
    public static int[] sortedSquares(int[] nums) {
        int[] square = new int[nums.length];

        int lo = 0;
        int hi = nums.length - 1;
        int idx = nums.length - 1;

        for(int i = 0; i < nums.length; i++) {
            int loSquared = nums[lo] * nums[lo];
            int hiSquared = nums[hi] * nums[hi];

            if(loSquared > hiSquared) {
                square[idx--] = loSquared;
                lo++;
            }else{
                square[idx--] = hiSquared;
                hi--;
            }
        }

        return square;
    }
}



// for(int i = 0; i < nums.length; i++) {
// square[i] = nums[i] * nums[i];
// }

// Arrays.sort(square);