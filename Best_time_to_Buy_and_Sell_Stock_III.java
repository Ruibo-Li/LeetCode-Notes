public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        return helper(prices,2);
    }
    public int helper(int[] prices,int k){
        int[][] local = new int[prices.length][k+1];
        int[][] global = new int[prices.length][k+1];
        for(int i=1;i<prices.length;i++){
            int dif = prices[i]-prices[i-1];
            for(int j=1;j<=k;j++){
                local[i][j] = Math.max(global[i-1][j-1]+Math.max(dif,0),local[i-1][j]+dif);
                global[i][j] = Math.max(local[i][j],global[i-1][j]);
            }
        }
        return global[prices.length-1][k];
    }
}