public class Solution {
    public int longestValidParentheses(String s) {
        int res = 0;
        int start = 0;
        Stack <Integer> st = new Stack <Integer> ();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(')
                st.push(i);
            else {
                if(st.isEmpty())
                    start = i+1;
                else {
                    st.pop();
                    if(st.isEmpty())
                        res = Math.max(res, i-start+1);
                    else
                        res = Math.max(res, i-st.peek());
                }
            }
        }
        return res;
    }
}