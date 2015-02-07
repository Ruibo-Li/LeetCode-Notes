public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A==null||A.length==0) return 1;
        for(int i=0;i<A.length;i++){
            if(A[i]>0&&A[i]<=A.length&&A[A[i]-1]!=A[i]){
                int tmp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = tmp;
                i--;
            }
        }
        int i = 0;
        while(i<A.length&&A[i]==i+1)i++;
        return i+1;
    }
}