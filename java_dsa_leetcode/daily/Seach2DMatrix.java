package java_dsa_leetcode.daily;


public class Seach2DMatrix {
    public static void main(String[] args){
        int[][] matrix = {
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}
        };
        int target = 3;

        var res = Search2D.searchMatrix(matrix, target);

        System.out.println(res);
    }
}

class Search2D
{
    public static boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while(row < rows && col >= 0) {
            int val = matrix[row][col];

            if(val == target) 
                return true;
            else if(val < target) 
                row++;
            else
                col--;
        }

        return false;
    }
}