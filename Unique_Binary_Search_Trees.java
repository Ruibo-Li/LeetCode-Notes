public class Solution {
    public int numTrees(int n) {
        if(n==0||n==1) return 1;
        int[] res = new int[n+1];
        res[0] = 1;
        for(int num=1;num<=n;num++){
            for(int i=0;i<num;i++) res[num] += res[i]*res[num-1-i];
        }
        return res[n];
    }
}