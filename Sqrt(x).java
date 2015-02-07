public class Solution {
    public int sqrt(int x) {
        if(x<=0) return 0;
        int l = 1;
        int r = x/2+1;
        while(l<=r){
            int mid = (l+r)/2;
            if(mid<=(x/mid) && mid+1>(x/(mid+1))) return mid;
            else if(mid<x/mid) l = mid+1;
            else r = mid-1;
        }
        return 0;
    }
}