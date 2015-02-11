public class Solution {
    public String getPermutation(int n, int k) {
        k--;
        List<Integer> num = new ArrayList<Integer> ();
        for(int i=1;i<=n;i++) num.add(i);
        int fac = 1;
        for(int i=2;i<n;i++) fac*=i;
        int times = n-1;
        StringBuilder res = new StringBuilder();
        while(times>=0) {
            int index = k/fac;
            res.append(num.get(index));
            num.remove(index);
            k = k%fac;
            if(times!=0) fac/=times;
            times--;
        }
        return res.toString();
    }
}