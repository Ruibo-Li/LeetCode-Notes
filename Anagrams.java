public class Solution {
    public List<String> anagrams(String[] strs) {
        HashMap <String,List<String>> map = new HashMap <String,List<String>> ();
        for(int i=0;i<strs.length;i++) {
            char[] chary = strs[i].toCharArray();
            Arrays.sort(chary);
            String str = new String (chary);
            if(map.containsKey(str)) 
                map.get(str).add(strs[i]);
            else {
                List<String> tmp = new ArrayList<String> ();
                tmp.add(strs[i]);
                map.put(str,tmp);
            }
        }
        List<String> res = new ArrayList<String> ();
        for(String key:map.keySet()) {
            List<String> cur = map.get(key);
            if(cur.size()>1)
                res.addAll(cur);
        }
        return res;
    }
}