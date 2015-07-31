public class Solution {
    public int countPrimes(int n) {
        int num = 0;
        boolean[] mark = new boolean[n];
        for(int i=2;i<n;i++) {
            if(mark[i])
                continue;
            num++;
            for(int j=i;j<n;j+=i)
                mark[j] = true;
        }
        return num;
    }
}