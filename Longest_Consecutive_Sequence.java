public class Solution {
    public int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int n: num)
            set.add(n);
        int res = 0;
        for(int n: num) {
            int count = 1;
            int left = n-1;
            int right = n+1;
            while(set.contains(left)) {
                set.remove(left);
                left--;
                count++;
            }
            while(set.contains(right)) {
                set.remove(right);
                right++;
                count++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}