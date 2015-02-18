public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length<3) return A.length;
        int index = 1;
        int count = 0;
        for(int i=1;i<A.length;i++) {
            if(A[i]!=A[i-1]) {
                count = 0;
                A[index] = A[i];
                index ++;
            }
            else {
                if(count==1)
                    continue;
                else{
                    A[index] = A[i];
                    index ++;
                    count ++;  
                } 
            }
        }
        return index;
    }
}