public class Solution {
    public boolean isPowerOfTwo(int n) {
        while(n>2) {
            if(n%2==1)
                return false;
            n /= 2;
        }
        if(n==2||n==1)
            return true;
        return false;
    }
}