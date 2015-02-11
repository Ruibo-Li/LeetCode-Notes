public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int level = n/2;
        int num = 1;
        for(int l=0;l<level;l++) {
            for(int i=l;i<n-l-1;i++)
                res[l][i] = num++;
            for(int i=l;i<n-l-1;i++)
                res[i][n-l-1] = num++;
            for(int i=n-l-1;i>l;i--)
                res[n-l-1][i] = num++;
            for(int i=n-l-1;i>l;i--)
                res[i][l] = num++;
        }
        if(n%2==1) res[level][level] = num;
        return res;
    }
}