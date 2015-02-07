public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0) return 0;
        if(s.length()==1) return 1;
        int max = 1;
        boolean[] rec = new boolean[256];
        for(int i=0;i<256;i++) rec[i] = false;
        int prev = 0;
        for(int i=0;i<s.length();i++){
            if(rec[s.charAt(i)]==false) rec[s.charAt(i)] = true;
            else{
                while(s.charAt(prev)!=s.charAt(i)){
                    rec[s.charAt(prev)] = false;
                    prev++;
                }
                prev++;
            }
            max = Math.max(max,i-prev+1);
        }
        return max;
    }
}