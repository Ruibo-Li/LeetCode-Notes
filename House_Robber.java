public class Solution {
    public int rob(int[] nums) {
        int odd = 0;
        int even = 0;
        for(int i=0;i<nums.length;i++) {
            if(i%2==1) 
                odd = Math.max(even, odd+nums[i]);
            else
                even = Math.max(odd, even+nums[i]);
        }
        return Math.max(odd, even);
    }
}