public class Solution {
    public String longestPalindrome(String s) {
        if(s==null||s.length()==1) return s;
        String res = s.substring(0,1);
        for(int i=0;i<s.length();i++){
            String tmp = helper(s,i,i);
            if(tmp.length()>res.length()) res = tmp;
            tmp = helper(s,i,i+1);
            if(tmp.length()>res.length()) res = tmp;
        }
        return res;
    }
    
    public String helper(String s,int start,int end){
        while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            end++;
            start--;
        }
        return s.substring(start+1,end);
    }
}