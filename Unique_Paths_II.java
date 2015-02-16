public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m==0) return 0;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1) return 0;
        res[m-1][n-1] = 1;
        int i,j;
        for(i=n-2;i>=0;i--){
            if(obstacleGrid[m-1][i]==1) res[m-1][i] = 0;
            else{
                res[m-1][i] = res[m-1][i+1];
            }
        }
        for(i=m-2;i>=0;i--){
            if(obstacleGrid[i][n-1]==1) res[i][n-1] = 0;
            else{
                res[i][n-1] = res[i+1][n-1];
            }
        }
        for(i=m-2;i>=0;i--){
            for(j=n-2;j>=0;j--){
                if(obstacleGrid[i][j]==1) res[i][j] = 0;
                else{
                    res[i][j] = res[i+1][j]+res[i][j+1];
                }
            }
        }
        return res[0][0];
    }
}