public class Solution {
    public int removeDuplicates(int[] A) {
        if(A==null||A.length<2)
            return A.length;
        int index = 1;
        for(int i=1;i<A.length;i++) {
            if(A[i]!=A[i-1]) {
                A[index] = A[i];
                index++;
            } 
        }
        return index;
    }
}