public class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++) dp[i][0] = i;
        for(int i=0;i<=word2.length();i++) dp[0][i] = i;
        for(int i=1;i<=word1.length();i++){
            char c1 = word1.charAt(i-1);
            for(int j=1;j<=word2.length();j++){
                char c2 = word2.charAt(j-1);
                if(c1==c2) dp[i][j] = dp[i-1][j-1];
                else{
                    int delete = dp[i-1][j]+1;
                    int add = dp[i][j-1]+1;
                    int replace = dp[i-1][j-1]+1;
                    dp[i][j] = Math.min(delete,Math.min(add,replace));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}