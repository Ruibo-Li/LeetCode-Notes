public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = find(nums, target-0.5);
        int[] res = {-1,-1};
        if(l>=nums.length||nums[l]!=target)
            return res;
        int r = find(nums, target+0.5)-1;
        res[0] = l;
        res[1] = r;
        return res;
    }
    public int find(int[] nums, double target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r) {
            int mid = (l+r)/2;
            if(nums[mid]<target)
                l = mid+1;
            else
                r = mid-1;
        }
        return l;
    }
}