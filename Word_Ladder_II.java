public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new LinkedList<List<String>>();
        LinkedList<List<String>> paths = new LinkedList<List<String>>();
        List<String> path0 = new LinkedList<String>();
        HashSet<String> wordperlevel = new HashSet<String>();
        path0.add(start);
        paths.add(path0);
        int level = 0;
        int maxl = Integer.MAX_VALUE;
        while(!paths.isEmpty()) {
            List<String> path = paths.removeFirst();
            if(path.size()>level) {
                level = path.size();
                dict.removeAll(wordperlevel);
                wordperlevel.clear();
                if(level==maxl)
                    break;
            }
            String cur = path.get(path.size()-1);
            if(cur.equals(end))
                res.add(path);
            for(int i=0;i<cur.length();i++) {
                char[] cry = cur.toCharArray();
                for(char c='a';c<='z';c++) {
                    cry[i] = c;
                    String tmp = new String(cry);
                    if(dict.contains(tmp)) {
                        wordperlevel.add(tmp);
                        LinkedList<String> newpath = new LinkedList<String>(path);
                        newpath.add(tmp);
                        paths.add(newpath);
                    }
                }
            }
        }
        return res;
    }
}