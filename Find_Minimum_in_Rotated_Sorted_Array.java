public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums[0];
        while (l < r) {
            int mid = (l + r) / 2;
            if (mid == l || mid == r)
                break;
            else if (nums[mid] > nums[l]) {
                min = Math.min(min, nums[l]);
                l = mid + 1;
            }
            else if (nums[mid] < nums[r]) {
                min = Math.min(min, nums[mid]);
                r = mid - 1;
            }
        }
        min = Math.min(Math.min(nums[l], nums[r]), min);
        return min;
    }
}