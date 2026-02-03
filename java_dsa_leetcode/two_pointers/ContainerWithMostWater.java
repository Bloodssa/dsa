
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        int maxArea = MaxArea.maxArea(height);

        System.out.println(maxArea);
    }
}

class MaxArea {
    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;

        while (l < r) {
            int width = r - l; // Get the current width of the container based on right - left to calculate the
                               // width
            int minHeight = Math.min(height[l], height[r]); // Get the lowest element either left or right that where
                                                            // the water can be store
            int area = width * minHeight; // Calculate the Area

            // System.out.println(area);
            maxArea = Math.max(maxArea, area); // Since we need to loop all element then get the max area result

            /**
             * 1,8,6,2,5,4,8,3,7
             * 
             * 1st
             * width = 8 - 0 = 8
             * minHeight = Math.min(1, 7) = 1 is the min height where container can store water
             * area = 8 * 1 = 8
             * maxArea = Math.max(0, 8) = max=8 is the first container, curr maxArea=8
             * move left since 1 < 7
             * 
             * 2nd
             * width = 8 - 1 = 7
             * minHeight = Math.min(8, 7) = 7 
             * area = 7 * 7 = 49 this is the most water container can contain
             * maxArea = Math.max(8, 49) since 49 is bigger to the 8 then 49 is the maxArea now we found the maxArea
             * move the r pinter since 8 < 7 is false
             * 
             * 3rd
             * width = 7 - 1 = 6
             * minHeight = Math.min(8, 3) = 3
             * area = 6 * 3 = 18
             * maxArea = Math.max(49, 18) still 49 is the maxArea
             * move the r since 8 < 3 is false
             * 
             * 4th
             * width = 6 - 1 = 5
             * minHeight = Math.min(8, 8) = 8
             * area = 5 * 8 = 40
             * maxArea = Math.max(49, 40) still 49 is the maxArea
             * move the r since 8 < 8 is false
             * 
             * 5th
             * width = 5 - 1 = 4
             * minHeight = Math.min(8, 4) = 4
             * area = 4 * 4 = 16
             * maxArea = Math.max(49, 16) still 49 is the maxArea
             * move the r since 8 < 4 is false
             * 
             * 6th 
             * width = 4 - 1 = 3
             * minHeight = Math.min(8, 5) = 5
             * area = 3 * 5 = 15
             * maxArea = Math.max(49, 15) still 49 is the maxArea
             * move the r since 8 < 5 is false
             * 
             * so on........................ then return the maxArea = 49
             */

            if (height[l] < height[r]) { // if l element is lower than the r then move the l to the next element else
                                         // move the r
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}

// TIME: O(N)
// SPACE: O(1)