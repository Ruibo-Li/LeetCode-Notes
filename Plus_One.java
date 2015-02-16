public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 1;
        ArrayList <Integer> res = new ArrayList <Integer> ();
        for(int i=len-1;i>=0;i--) {
            int num = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            res.add(num);
        }
        if (carry>0) res.add(carry);
        int[] ret = new int[res.size()];
        for(int i=0;i<res.size();i++) 
            ret[i] = res.get(res.size()-1-i);
        return ret;
    }
}