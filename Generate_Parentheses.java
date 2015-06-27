public class Solution {
    public List<String> generateParenthesis(int n) {
        List <String> res = new LinkedList <String> ();
        StringBuilder sb = new StringBuilder ();
        helper(res, sb, 0, 0, n);
        return res;
    }
    public void helper(List <String> res, StringBuilder sb, int l, int r, int n) {
        if(l==n&&r==n) {
            res.add(sb.toString());
            return;
        }        
        if(l<n) {
            sb.append('(');
            helper(res, sb, l+1, r, n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(r<l) {
            sb.append(')');
            helper(res, sb, l, r+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}