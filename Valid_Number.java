public class Solution {
    public boolean isNumber(String s) {
        boolean num = false;
        boolean exp = false;
        boolean dot = false;
        String str = s.trim();
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)>='0' && str.charAt(i)<='9')
                num = true;
            else if(str.charAt(i)=='+' || str.charAt(i)=='-') {
                if(i!=0 && str.charAt(i-1)!='e')
                    return false;
            }
            else if(str.charAt(i)=='e') {
                if(!num||exp) return false;
                exp = true;
                num = false;
            }
            else if(str.charAt(i)=='.') {
                if(dot||exp) return false;
                dot = true;
            }
            else
                return false;
        }
        return num;
    }
}