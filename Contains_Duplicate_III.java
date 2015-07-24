public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i=0;i<nums.length;i++) {
            int n = nums[i];
            if(set.floor(n)!=null&&(long)n-(long)set.floor(n)<=t||set.ceiling(n)!=null&&(long)set.ceiling(n)-(long)n<=t)
                return true;
            set.add(n);
            if(i>=k)
                set.remove(nums[i-k]);
        }
        return false;
    }
}