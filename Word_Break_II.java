public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new LinkedList<String>();
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0;i<s.length();i++) {
            if(!dp[i])
                continue;
            for(String word: wordDict) {
                int len = word.length();
                if(i+len<=s.length()&&word.equals(s.substring(i, i+len)))
                    dp[i+len] = true;
            }
        }
        if(!dp[s.length()])
            return res;
        List<List<String>> rec = new LinkedList<List<String>>();
        find(s, rec, new LinkedList<String>(), wordDict, 0);
        for(List<String> list: rec) {
            StringBuilder sb = new StringBuilder();
            int i;
            for(i=0;i<list.size()-1;i++) {
                sb.append(list.get(i));
                sb.append(' ');
            }
            sb.append(list.get(i));
            res.add(sb.toString());
        }
        return res;
    }
    public void find(String s, List<List<String>> rec, List<String> tmp, Set<String> wordDict, int pos) {
        if(pos==s.length()) {
            rec.add(new LinkedList<String>(tmp));
            return;
        }
        for(String word: wordDict) {
            int len = word.length();
            if(pos+len<=s.length()&&word.equals(s.substring(pos, pos+len))) {
                tmp.add(word);
                find(s, rec, tmp, wordDict, pos+len);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}