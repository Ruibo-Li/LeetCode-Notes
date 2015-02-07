public class Solution1 {
    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE;
        return helper(A,0,A.length-1,max);
    }
    public int helper(int[] A,int l,int r,int max){
        if(l>r) return Integer.MIN_VALUE;
        int mid = (l+r)/2;
        int lsum = helper(A,l,mid-1,max);
        int rsum = helper(A,mid+1,r,max);
        max = Math.max(max,Math.max(lsum,rsum));
        int left = 0;
        int lm = 0;
        int right = 0;
        int rm = 0;
        for(int i=mid-1;i>=l;i--){
            left += A[i];
            lm = Math.max(lm,left);
        }
        for(int i=mid+1;i<=r;i++){
            right += A[i];
            rm = Math.max(rm,right);
        }
        max = Math.max(max,lm+rm+A[mid]);
        return max;
    }
}

public class Solution2 {
    public int maxSubArray(int[] A) {
        int max = A[0];
        int[] dp = new int[A.length];
        dp[0] = A[0];
        for(int i=1;i<A.length;i++) {
            dp[i] = Math.max(dp[i-1]+A[i],A[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}