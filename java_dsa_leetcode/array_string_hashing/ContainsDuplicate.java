package java_dsa_leetcode.array_string_hashing;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args){
        int[] nums = {1,2,3,4};

        boolean res = Duplicate.containsDuplicate(nums);
        System.out.println(res);
    }
}


class Duplicate
{
    public static boolean containsDuplicate(int[] nums) {
        
        Set<Integer> dupSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(dupSet.contains(nums[i])) { // check if the element is inside the set
                return true;
            }

            dupSet.add(nums[i]); // duplicate not found
        }

        return false;
    }
}

// TIME: O(N)
// SPACE: O(N)