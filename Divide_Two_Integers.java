public class Solution {
    public int divide(int dividend, int divisor) {
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long sum = 0;
        long pow = 0;
        long res = 0;
        while(a>=b){
            sum = b;
            pow = 1;
            while(sum+sum<=a){
                sum += sum;
                pow += pow;
            }
            a -= sum;
            res += pow;
        }
        if((dividend>0&&divisor<0)||(dividend<0&&divisor>0)) res = -res;
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int)res;
    }
}