public class Solution {
    int res;
    public int totalNQueens(int n) {
        res = 0;
        int[] loc = new int[n];
        helper(loc,n,0);
        return res;
    }
    public void helper(int[] loc,int n,int cur){
        if(cur==n){
            res++;
            return;
        }
        else{
            for(int i=0;i<n;i++){
                loc[cur] = i;
                if(valid(loc,cur,n)) helper(loc,n,cur+1);
            }
            return;
        }
    }
    public boolean valid(int[] loc,int cur,int n){
        for(int i=0;i<cur;i++){
            if(loc[i]==loc[cur]) return false;
            if(Math.abs(loc[i]-loc[cur])==cur-i) return false;
        }
        return true;
    }
}