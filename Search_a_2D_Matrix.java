public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0) return false;
        int n = matrix[0].length;
        int left = 0;
        int right = m-1;
        while(left<=right) {
            int mid = (left+right)/2;
            if(matrix[mid][0]==target)
                return true;
            else if(matrix[mid][0]<target)
                left = mid+1;
            else
                right = mid-1;
        }
        int row = right;
        if(row<0)
            return false;
        left = 0;
        right = n-1;
        while(left<=right) {
            int mid = (left+right)/2;
            if(matrix[row][mid]==target) 
                return true;
            else if(matrix[row][mid]<target)
                left = mid+1;
            else
                right = mid-1; 
        }
        return false;
    }
}