// LEETCODE: 80. Remove Duplicates from Sorted Array II
public class RemoveDuplicatesII {
    public static void main (String[] a){
        int[] nums = {0,0,1,1,1,1,2,3,3};

        int res = RemoveTwo.removeDuplicates(nums);

        System.out.println("RES: " + res);
        for(int i = 0; i < res; i++){
            System.out.print(nums[i] + " ");
        }
    }
}

class RemoveTwo
{
    public static int removeDuplicates(int[] nums) 
    {
        int s = 2;

        /**
         * Start the f pointer at index 2 since only to duplicates allowed
         * -2 to the s pointer to check the first occurence of the element if it appear twice
         * check if its not equal then swap the s pointr to the element of the f
         * increment 1 the s pointer to allow to check a one elemnt the occure once
         * 
         * EX OF ONE OCCURENCE ELEMENT:
         *                     r
         * 0, 0,  1,  1, 1, 1, 2, 3, 3
         *       s-1     s
         * swap since s-1 = 1 != 2
         * 
         * 0, 0, 1, 1, 2, 1, 2, 3, 3
         */
        for(int f = 2; f < nums.length; f++){
            if(nums[f] != nums[s - 2]) {
                nums[s] = nums[f];
                s++;
            }
        }
        
        return s; // return the s as length since it tracks to the duplicates
    }
}

// TIME: O(n)
// SPACE: O(1)