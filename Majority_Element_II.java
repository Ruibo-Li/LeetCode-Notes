public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();
        int cdd1 = 0;
        int cdd2 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int n: nums) {
            if(n==cdd1)
                c1++;
            else if(n==cdd2)
                c2++;
            else if(c1==0) {
                cdd1 = n;
                c1 = 1;
            }
            else if(c2==0) {
                cdd2 = n;
                c2 = 1;
            }
            else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int n: nums) {
            if(n==cdd1)
                c1++;
            else if(n==cdd2)
                c2++;
        }
        if(c1>nums.length/3)
            res.add(cdd1);
        if(c2>nums.length/3)
            res.add(cdd2);
        return res;
    }
}