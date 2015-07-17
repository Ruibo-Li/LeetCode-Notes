public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m==0)
            return 0;
        int n = matrix[0].length;
        int[][] rec = new int[m][n];
        for(int i=0;i<n;i++)
            rec[0][i] = matrix[0][i]-'0';
        for(int i=1;i<m;i++)
            for(int j=0;j<n;j++) {
                if(matrix[i][j]=='0')
                    rec[i][j] = 0;
                else
                    rec[i][j] = rec[i-1][j]+1;
            }
        int res = 0;
        for(int i=0;i<m;i++)
            res = Math.max(res, findMax(rec[i]));
        return res;
    }
    public int findMax(int[] height) {
        int[] h = Arrays.copyOf(height, height.length+1);
        int i = 0;
        int res = h[0];
        Stack <Integer> st = new Stack <Integer> ();
        while(i<=height.length) {
            if(st.isEmpty()||h[i]>=h[st.peek()])
                st.push(i++);
            else {
                int s = st.pop();
                res = Math.max(res, h[s]*(st.isEmpty()?i:i-st.peek()-1));
            }
        }
        return res;
    }
}