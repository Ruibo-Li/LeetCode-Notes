public class Solution {
    public int removeDuplicates(int[] A) {
        if(A==null||A.length<3)
            return A.length;
        int index = 0;
        int count = 0;
        for(int i=0;i<A.length;i++) {
            if(i>0&&A[i]!=A[i-1])
                count = 0;
            if(count<2) {
                A[index] = A[i];
                index++;
                count++;
            }
        }
        return index;
    }
}