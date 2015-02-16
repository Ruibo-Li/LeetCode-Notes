public class Solution {
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int[] rec = new int[n];
        rec[n-1] = 1;
        rec[n-2] = 2;
        for(int i=n-3;i>=0;i--)
            rec[i] = rec[i+1] + rec[i+2];
        return rec[0];
    }
}