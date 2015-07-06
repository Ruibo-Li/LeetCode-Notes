public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int mark = -1;
        int star = -1;
        while(i<s.length()) {
            if(j<p.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')) {
                i++;
                j++;
            }
            else if(j<p.length()&&p.charAt(j)=='*') {
                star = j;
                j++;
                mark = i;
            }
            else if(star!=-1) {
                j = star+1;
                mark++;
                i = mark;
            }
            else
                return false;
        }
        while(j<p.length()&&p.charAt(j)=='*')
            j++;
        return j==p.length();
    }
}