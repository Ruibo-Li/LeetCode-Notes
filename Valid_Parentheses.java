public class Solution {
    public boolean isValid(String s) {
        Stack st = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[') st.push(s.charAt(i));
            if(s.charAt(i)==')'){
                if(st.isEmpty()||(char)st.pop()!='(') return false;
            }
            if(s.charAt(i)=='}'){
                if(st.isEmpty()||(char)st.pop()!='{') return false;
            }
            if(s.charAt(i)==']'){
                if(st.isEmpty()||(char)st.pop()!='[') return false;
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}