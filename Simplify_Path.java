public class Solution {
    public String simplifyPath(String path) {
        Stack st = new Stack();
        String[] strs = path.split("/");
        for(String str:strs) {
            if(str.length()==0||str.equals("."))
                continue;
            else if(!str.equals(".."))
                st.push(str);
            else
                if(!st.isEmpty())
                    st.pop();
        }
        StringBuilder res = new StringBuilder ();
        while(!st.isEmpty()) {
            res = res.insert(0,st.pop());
            res = res.insert(0,'/');
        }
        if(res.length()==0) return "/";
        return res.toString();
    }
}