public class Solution {
    public String shortestPalindrome(String s) {
        if(s.length()<=1) return s;
        int center = (s.length()-1) / 2;
        String res = "";
        for(int i=center;i>=0;i--) {
            if(s.charAt(i)==s.charAt(i+1)) {
                res = check(s, i, i+1);
                if(res!=null)
                    return res;
            }
            res = check(s, i, i);
            if(res!=null)
                return res;
        }
        return res;
    }
    
    public String check(String s, int l, int r) {
        int i;
        for(i=1;l-i>=0;i++) {
            if(s.charAt(l-i)!=s.charAt(r+i))
                break;
        }
        if(l-i>=0)
            return null;
        String part = s.substring(r+i);
        StringBuilder sb = new StringBuilder(part);
        return sb.reverse().append(s).toString();
    }
}