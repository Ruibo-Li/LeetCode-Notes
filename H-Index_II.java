public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==0)
            return 0;
        int l = 0;
        int r = citations.length-1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(citations[mid]<citations.length-mid)
                l = mid+1;
            else if(citations[mid]>citations.length-mid)
                r = mid-1;
            else
                return citations.length-mid;
        }
        return citations.length-l;
    }
}