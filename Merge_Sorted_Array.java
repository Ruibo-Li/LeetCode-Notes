public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1;
        int i = m-1;
        int j = n-1;
        for(;i>=0||j>=0;k--) {
            int num = Integer.MIN_VALUE;
            if(i>=0)
                num = Math.max(num, nums1[i]);
            if(j>=0)
                num = Math.max(num, nums2[j]);
            if(i>=0&&num==nums1[i])
                i--;
            else if(j>=0&&num==nums2[j])
                j--;
            nums1[k] = num;
        }
        return;
    }
}