public class Solution {
    public int maxProduct(int[] A) {
        int max = A[0];
        int[] mpro = new int[A.length];
        int[] minpro = new int[A.length];
        mpro[0] = A[0];
        minpro[0] = A[0];
        int i;
        for(i=1;i<A.length;i++){
            int a = minpro[i-1]*A[i];
            int b = mpro[i-1]*A[i];
            minpro[i] = Math.min(A[i],Math.min(a,b));
            mpro[i] = Math.max(A[i],Math.max(a,b));
            max = Math.max(mpro[i],max);
        }
        return max;
    }
}