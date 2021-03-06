public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        dp[0][0] = 1;
        for(int j=1;j<t.length()+1;j++)
            dp[0][j] = 0;
        for(int i=1;i<s.length()+1;i++)
            dp[i][0] = 1;
        for(int i=1;i<s.length()+1;i++)
            for(int j=1;j<t.length()+1;j++) {
                dp[i][j] = dp[i-1][j];
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j] += dp[i-1][j-1];
            }
        return dp[s.length()][t.length()];
    }
}