package java_dsa_leetcode.binary_search;

public class CountNegativeNumMatrix {
    public static void main(String[] args){
        int[][] grid = {
            {4,3,2,-1},
            {3,2,1,-1},
            {1,1,-1,-2},
            {-1,-1,-2,-3}
        };

        var res = NumOfNegative.countNegatives(grid);

        System.out.println(res);
    }
}

class NumOfNegative
{
    public static int countNegatives(int[][] grid) {
        
        int negative = 0;
        int rows = grid.length;
        
        int row = 0;
        int col = grid[0].length - 1;

        while(row < rows && col >= 0) {
            int gridVal = grid[row][col];
            // System.out.println(gridVal);
            if(gridVal < 0) {
                negative += (rows - row);
                // System.out.println("N: " + negative);
                col--;
            }else{
                row++;
            }
        }
        return negative;
    }
}