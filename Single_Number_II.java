public class Solution1 {
    public int singleNumber(int[] A) {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        for(int i=0;i<A.length;i++){
            twos |= (ones&A[i]);
            ones ^= A[i];
            threes = ones&twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}

public class Solution2 {
    public int singleNumber(int[] A) {
        int[] count = new int[32];
        int res = 0;
        for(int i=0;i<32;i++){
            for(int j=0;j<A.length;j++) {
                if(((A[j] >> i )& 1) == 1) 
                    count[i] = (count[i]+1)%3;
            }
            res |= (count[i] << i);
        }
        return res;
    }
}