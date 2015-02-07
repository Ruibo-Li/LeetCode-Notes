public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int total = A.length+B.length;
        if(total%2==1) return helper(A,B,total/2+1);
        else{
            return (helper(A,B,total/2)+helper(A,B,total/2+1))/2.0;
        }
    }
    public double helper(int A[],int B[],int k){
        if(A.length>B.length) return helper(B,A,k);
        if(A.length==0) return (double)B[k-1];
        if(k==1) return (double)Math.min(A[0],B[0]);
        int pa = Math.min(k/2,A.length);
        int pb = k-pa;
        if(A[pa-1]<B[pb-1]) return helper(Arrays.copyOfRange(A,pa,A.length),B,k-pa);
        else if(A[pa-1]>B[pb-1]) return helper(A,Arrays.copyOfRange(B,pb,B.length),k-pb);
        else{
            return (double) A[pa-1];
        }
    }
}