public class Solution {
    public int reverse(int x) {
        boolean flag = false;
        if(x<0) {
            x = -x;
            flag = true;
        }
        long res = 0;
        while(x>0){
            int m = x%10;
            x /= 10;
            res = res*10+m;
        }
        if(res>Integer.MAX_VALUE) return 0;
        if(flag) res = -res;
        return (int)res;
    }
}