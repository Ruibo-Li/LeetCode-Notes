public class Solution {
    public int calculate(String s) {
        Stack <Integer> st = new Stack <Integer> ();
        int res = 0;
        int sign = 1;
        for(int i=0;i<s.length();i++) {
            if(Character.isDigit(s.charAt(i))) {
                int cur = s.charAt(i)-'0';
                while(i+1<s.length()&&Character.isDigit(s.charAt(i+1))) {
                    i++;
                    cur = cur*10 + s.charAt(i)-'0';
                }
                res += sign*cur;
            }
            else if(s.charAt(i)=='+')
                sign = 1;
            else if(s.charAt(i)=='-')
                sign = -1;
            else if(s.charAt(i)=='(') {
                st.push(res);
                res = 0;
                st.push(sign);
                sign = 1;
            }
            else if(s.charAt(i)==')') {
                res =  st.pop()*res+st.pop();
            }
        }
        return res;
    }
}