import java.util.Arrays;

public class SortColor {
    public static void main (String[] args){
        int[] nums = {2,0,2,1,1,0};

        Colors.sortColors(nums);

        System.out.println(Arrays.toString(nums));

    }
}

class Colors
{
    public static void sortColors(int[] nums) 
    {
        int low = 0; // pointers to the zero
        int mid = 0;// Pointers to the needed to check as cur val
        int high = nums.length - 1; // pointers to the 2

        while(mid <= high){
            int cur = nums[mid];

            if(cur == 0){ // if the cur val or mid is 0 then put it in the back or low swap it
                sortHelper(nums, low, mid);
                low++;
                mid++;
            }else if(cur == 2) { // if mid is 2 then swap it to the high pointer to put iot the the last
                                 // dont increment the mid because if the or the high points to a zero then in next iterate put it in the low part of the array
                sortHelper(nums, high, mid);
                high--;
            }else{
                mid++; // skip the 1 val because the 1 might be already in correct or relative place 
            }
        }
    }

    public static void sortHelper(int[] nums, int l, int r)
    {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}

// TIME: O(n)
// SPACE: O(1)
