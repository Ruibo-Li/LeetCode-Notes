public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] rec = new int[m][n];
        if(dungeon[m-1][n-1]<0) rec[m-1][n-1] = -dungeon[m-1][n-1]+1;
        else{
            rec[m-1][n-1] = 1;
        }
        for(int i=m-2;i>=0;i--) rec[i][n-1] = Math.max(1,rec[i+1][n-1]-dungeon[i][n-1]);
        for(int i=n-2;i>=0;i--) rec[m-1][i] = Math.max(1,rec[m-1][i+1]-dungeon[m-1][i]);
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                rec[i][j] = Math.max(1,Math.min(rec[i+1][j],rec[i][j+1])-dungeon[i][j]);
            }
        }
        return rec[0][0];
    }
}