public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length()==0)
            return s.length()==0;
        if(p.length()==1) {
            if(s.length()==0)
                return false;
            if(s.charAt(0)!=p.charAt(0)&&p.charAt(0)!='.')
                return false;
            else
                return s.length()==1;
        }
        if(p.charAt(1)!='*') {
            if(s.length()==0)
                return false;
            if(s.charAt(0)!=p.charAt(0)&&p.charAt(0)!='.')
                return false;
            else
                return isMatch(s.substring(1), p.substring(1));
        }
        else {
            if(isMatch(s, p.substring(2)))
                return true;
            if(s.length()>0&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.'))
                return isMatch(s.substring(1), p);
        }
        return false;
    }
}