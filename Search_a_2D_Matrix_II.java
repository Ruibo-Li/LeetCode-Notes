public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0)
            return false;
        int n = matrix[0].length;
        int col = n-1;
        int row = 0;
        while(col>=0&&row<m) {
            if(matrix[row][col]<target)
                row++;
            else if(matrix[row][col]>target)
                col--;
            else
                return true;
        }
        return false;
    }
}