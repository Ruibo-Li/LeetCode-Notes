public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return QS(nums, 0, nums.length-1, k-1);
    }
    public int QS(int[] nums, int l, int r, int k) {
        int mid = partition(nums, l, r);
        if(k==mid) return nums[k];
        else if(k<mid)
            return QS(nums, l, mid-1, k);
        else
            return QS(nums, mid+1, r, k);
    }
    public int partition(int[] nums, int l, int r) {
        int K = nums[l];
        while(l<r) {
            while(l<r && nums[r]<=K)
                r--;
            nums[l] = nums[r];
            while(l<r && nums[l]>=K)
                l++;
            nums[r] = nums[l];
        }
        nums[l] = K;
        return l;
    }
}