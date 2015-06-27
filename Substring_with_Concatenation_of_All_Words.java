public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List <Integer> res = new LinkedList <Integer> ();
        int wordnum = words.length;
        if(wordnum==0)
            return res;
        int strlen = wordnum*words[0].length();
        for(int i=0;i<=s.length()-strlen;i++) {
            if(selected(s.substring(i,i+strlen), words))
                res.add(i);
        }
        return res;
    }
    public boolean selected(String str, String[] words) {
        int wordlen = words[0].length();
        String cur;
        HashMap <String, Integer> map = new HashMap <String, Integer> ();
        for(String word:words) {
            if(!map.containsKey(word))
                map.put(word, 1);
            else
                map.put(word, map.get(word)+1);
        }
        for(int i=0;i<=str.length()-wordlen;i+=wordlen) {
            cur = str.substring(i,i+wordlen);
            if(!map.containsKey(cur)||map.get(cur)==0)
                return false;
            map.put(cur, map.get(cur)-1);
        }
        return true;
    }
}