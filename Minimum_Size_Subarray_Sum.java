public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int start = 0;
        int end = 0;
        int res = len+1;
        int sum = 0;
        while(end<len) {
            while(end<len && sum<s) {
                sum += nums[end];
                end++;
            }
            while(start<end && sum>=s) {
                res = Math.min(res,end-start);
                sum -= nums[start];
                start++;
            }
        }
        if(res>len)
            return 0;
        return res;
    }
}