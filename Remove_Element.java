public class Solution {
    public int removeElement(int[] A, int elem) {
        int index = 0;
        int res = A.length;
        for(int i=0;i<A.length;i++){
            if(A[i]!=elem){
                A[index] = A[i];
                index++;
            }
            else{
                res--;
            }
        }
        if(index==0) return 0;
        return res;
    }
}