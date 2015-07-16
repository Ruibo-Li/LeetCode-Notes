public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List <Integer> res = new LinkedList <Integer> ();
        int m = matrix.length;
        if(m==0)
            return res;
        int n = matrix[0].length;
        int num = Math.min(m,n);
        int level = num/2;
        for(int i=0;i<level;i++) {
            for(int j=i;j<n-1-i;j++)
                res.add(matrix[i][j]);
            for(int j=i;j<m-1-i;j++)
                res.add(matrix[j][n-1-i]);
            for(int j=n-1-i;j>i;j--)
                res.add(matrix[m-1-i][j]);
            for(int j=m-1-i;j>i;j--)
                res.add(matrix[j][i]);
        }
        if(num%2==1) {
            if(m>=n) 
                for(int i=level;i<m-level;i++)
                    res.add(matrix[i][level]);
            else 
                for(int i=level;i<n-level;i++)
                    res.add(matrix[level][i]);
        }
        return res;
    }
}