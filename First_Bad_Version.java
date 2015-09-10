/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long l = 1;
        long r = n;
        while(l<=r) {
            int mid = (int)((l+r)/2);
            if(isBadVersion(mid))
                r = mid-1;
            else
                l = mid+1;
        }
        return (int)l;
    }
}