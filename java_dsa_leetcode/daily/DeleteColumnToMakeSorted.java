package java_dsa_leetcode.daily;

public class DeleteColumnToMakeSorted {
    public static void main(String[] args) {
        String[] str = {"cba","daf","ghi"}; 

        var res = DeleteCols.minDeletionSize(str);
        System.out.println(res);
    }   
}

class DeleteCols
{
    public static int minDeletionSize(String[] strs) {
        if (strs == null || strs.length == 0) return 0;

        int rows = strs.length;
        int cols = strs[0].length();
        int colsToRemove = 0;

        for(int c = 0; c < cols; c++) {
            for(int r = 1; r < rows; r++) {
                if(strs[r].charAt(c) < strs[r - 1].charAt(c)) {
                    colsToRemove++;
                    break;
                }
            }
        }

        return colsToRemove;
    }
}
// TIME: O(N*M) where n is the row and m is the cols
// SPACE: O(1)