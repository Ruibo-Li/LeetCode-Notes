public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++) {
            res<<=1;
            int bit = n&1;
            res |= bit;
            n>>=1;
        }
        return res;
    }
}