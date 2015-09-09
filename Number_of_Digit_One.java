public class Solution {
    public int countDigitOne(int n) {
        long a;
        long b;
        int res = 0;
        for(long m = 1;m<=n;m*=10) {
            a = n/m;
            b = n%m;
            res += (a+8)/10*m;
            if(a%10==1)
                res += b+1;
        }
        return res;
    }
}