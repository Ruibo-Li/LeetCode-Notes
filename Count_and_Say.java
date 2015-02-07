public class Solution {
    public String countAndSay(int n) {
        if(n<=0) return "";
        String cur = "1";
        int start = 1;
        while(start<n){
            StringBuilder res = new StringBuilder();
            int count = 1;
            for(int i=1;i<cur.length();i++){
                if(cur.charAt(i-1)==cur.charAt(i)) count++;
                else{
                    res.append(count);
                    res.append(cur.charAt(i-1));
                    count = 1;
                }
            }
            res.append(count);
            res.append(cur.charAt(cur.length()-1));
            cur = res.toString();
            start++;
        }
        return cur;
    }
}