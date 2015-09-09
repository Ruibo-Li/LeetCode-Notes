public class Solution {
    public int calculate(String s) {
        int res = 0;
        int n1 = 0;
        int n2 = 0;
        int sign = 1;
        int op = 0;
        n1 = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c==' ')
                continue;
            if(Character.isDigit(c)) 
                n1 = n1*10+(c-'0');
            else {
                if(op==1)
                    n1 = n2*n1;
                if(op==-1)
                    n1 = n2/n1;
                op = 0;
                if(c=='+'||c=='-') {
                    res += sign*n1;
                    sign = c=='+'? 1:-1;
                }
                else if(c=='*'||c=='/') {
                    n2 = n1;
                    op = c=='*'? 1:-1;
                }
                n1 = 0;
            }
        }
        if(op==1)
            res += sign*n2*n1;
        else if(op==-1)
            res += sign*n2/n1;
        else
            res += sign*n1;
        return res;
    }
}