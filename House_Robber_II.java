public class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        return Math.max(subrob(nums,1,nums.length), subrob(nums,0,nums.length-1));
    }
    
    public int subrob(int[] nums, int l, int r) {
        int odd = 0;
        int even = 0;
        for(int i=l;i<r;i++) {
            if(i%2==1)
                odd = Math.max(odd+nums[i],even);
            else
                even = Math.max(even+nums[i],odd);
        }
        return Math.max(odd,even);
    }
}