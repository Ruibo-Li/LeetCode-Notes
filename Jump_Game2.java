public class Solution {
    public int jump(int[] nums) {
        int max = 0;
        int last = 0;
        int step = 0;
        for(int i=0;i<=max&&i<nums.length;i++) {
            if(i>last) {
                last = max;
                step++;
            }
            max = Math.max(i+nums[i],max);
        }
        if(max>=nums.length-1)
            return step;
        return -1;
    }
}