public class Solution {
    public double pow(double x, int n) {
        if(n==0) return 1;
        double half = pow(x,n/2);
        double res;
        if(n%2==0) 
            res = half*half;
        else {
            if(n>0) res = half*half*x;
            else
                res = half*half/x;
        }
        return res;
    }
}