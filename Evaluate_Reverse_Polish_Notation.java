public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<tokens.length;i++) {
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")) {
                int n2 = st.pop();
                int n1 = st.pop();
                if(tokens[i].equals("+")) 
                    st.push(n1+n2);
                else if(tokens[i].equals("-"))
                    st.push(n1-n2);
                else if(tokens[i].equals("*"))
                    st.push(n1*n2);
                else if(tokens[i].equals("/"))
                    st.push(n1/n2);
            }
            else
                st.push(Integer.parseInt(tokens[i]));
        }
        return st.pop();
    }
}