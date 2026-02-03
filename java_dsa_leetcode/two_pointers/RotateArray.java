import java.util.Arrays;

public class RotateArray {
    public static void main(String[] a) {
        int[] nums = {-1};
        int k = 2;

        Rotate.rotate(nums, k);

        System.out.println("Res: " + Arrays.toString(nums));
    }
}

class Rotate {

    public static void rotate(int[] nums, int k) {

        k = k % nums.length;

        if(k == 0) {
            return;
        }

        int start = 0;
        int[] rightCopy = new int[k];

        int e = nums.length - k;
        int[] leftCopy = new int[e];

        for (int i = e; i < nums.length; i++) {
            rightCopy[start] = nums[i];
            start++;
        }
        for (int i = 0; i < e; i++) {
            leftCopy[i] = nums[i];
        }

        for (int i = 0; i < rightCopy.length; i++) {
            nums[i] = rightCopy[i];
        }

        for (int i = 0; i < leftCopy.length; i++) {
            nums[rightCopy.length + i] = leftCopy[i];
        }

        System.out.println(Arrays.toString(rightCopy));
        System.out.println(Arrays.toString(leftCopy));
    }
}