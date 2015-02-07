public class Solution {
    public int removeDuplicates(int[] A) {
        int l = A.length;
        if(l==0) return 0;
        int i = 0;
        int j = 1;
        while(j<l){
            if(A[j]==A[i]) j++;
            else{
                i++;
                A[i] = A[j];
                j++;
            }
        }
        return i+1;
    }
}