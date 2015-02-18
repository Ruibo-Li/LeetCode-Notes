public class Solution {
    public boolean search(int[] A, int target) {
        int l = 0;
        int r = A.length-1;
        while(l<=r) {
            int mid = (l+r) / 2;
            if(A[mid]==target) return true;
            if(A[mid]>A[l]) {
                if(A[mid]>target&&A[l]<=target)
                    r = mid-1;
                else
                    l = mid+1;
            }
            else if(A[mid]<A[l]) {
                if(A[mid]<target&&A[r]>=target)
                    l = mid+1;
                else
                    r = mid-1;
            }
            else
                l++;
        }
        return false;
    }
}