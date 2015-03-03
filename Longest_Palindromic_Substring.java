public class Solution1 {
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

public class Solution2 {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++) 
            for(int j=0;j<s.length();j++)
                dp[i][j] = false;
        
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++) {
            for(int j=0;j<i;j++) {
                dp[j][i] = (s.charAt(j)==s.charAt(i)&&(dp[j+1][i-1]||(i-j<2)));
                if(dp[j][i]&&(i-j)>(end-start)) {
                    end = i;
                    start = j;
                }
            }
            dp[i][i] = true;
        }
        return s.substring(start,end+1);
    }
}