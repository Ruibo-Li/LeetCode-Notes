public class Solution {
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        int[] d = new int[num1.length()+num2.length()];
        for(int i=0;i<n1.length();i++) 
            for(int j=0;j<n2.length();j++) 
                d[i+j] += ((n1.charAt(i)-'0')*(n2.charAt(j)-'0'));
        int carry = 0;
        StringBuilder res = new StringBuilder();
        for(int i=0;i<d.length;i++) {
            int digit = (d[i]+carry)%10;
            carry = (d[i]+carry)/10;
            res.insert(0, digit);
        }
        if(carry!=0)
            res.insert(0,carry);
        int i = 0;
        while(res.charAt(i)=='0'&&res.length()>1) {
            res.deleteCharAt(0);
        }
        return res.toString();
    }
}