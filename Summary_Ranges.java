public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<String>();
        int i = 0;
        while(i<nums.length) {
            int min = nums[i];
            int max = nums[i];
            while(i<nums.length-1&&nums[i+1]==nums[i]+1)
                i++;
            max = nums[i];
            StringBuilder sb = new StringBuilder();
            sb.append(min);
            if(min!=max) {
                sb.append("->");
                sb.append(max);
            }
            res.add(sb.toString());
            i++;
        }
        return res;
    }
}