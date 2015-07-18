public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<String> ();
        if(s.length()<4||s.length()>12)
            return res;
        dfs(res, "", s, 0);
        return res;
    }
    public void dfs(List<String> res, String tmp, String s,int count) {
        if(count==3&&isValid(s)) {
            res.add(tmp+s);
            return;
        }
        for(int i=1;i<4&&i<s.length();i++) 
            if(isValid(s.substring(0,i)))
                dfs(res, tmp+s.substring(0,i)+'.', s.substring(i), count+1);
    }
    public boolean isValid(String s) {
        if(s.charAt(0)=='0')
            return s.equals("0");
        int val = Integer.parseInt(s);
        return val>=0&&val<=255;
    }
}