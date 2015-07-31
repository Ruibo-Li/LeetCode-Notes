public class Solution {
    int res;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m==0)
            return 0;
        res = 0;
        int n = grid[0].length;
        for(int i=0;i<m;i++) 
            for(int j=0;j<n;j++) 
                if(grid[i][j]=='1') {
                    res++;
                    fill(grid, i, j, m, n);
                }
        return res;
    }
    public void fill(char[][] grid, int i, int j, int m, int n) {
        grid[i][j] = '2';
        if(i>0&&grid[i-1][j]=='1')
            fill(grid, i-1, j, m, n);
        if(i<m-1&&grid[i+1][j]=='1')
            fill(grid, i+1, j, m, n);
        if(j>0&&grid[i][j-1]=='1')
            fill(grid, i, j-1, m, n);
        if(j<n-1&&grid[i][j+1]=='1')
            fill(grid, i, j+1, m, n);
    }
}