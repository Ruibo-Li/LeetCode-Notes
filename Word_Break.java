public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] rec = new boolean[s.length()+1];
        rec[0] = true;
        for(int i=0;i<s.length();i++) {
            if(!rec[i])
                continue;
            for(String word: wordDict) {
                int len = word.length();
                if(i+len<=s.length()&&word.equals(s.substring(i, i+len)))
                    rec[i+len] = true; 
            }
        }
        return rec[s.length()];
    }
}