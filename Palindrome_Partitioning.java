public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<List<String>>();
        if(s.length()==0)
            return res;
        find(res, new LinkedList<String>(), 0, s);
        return res;
    }
    public void find(List<List<String>> res, List<String> tmp, int pos, String s) {
        if(pos==s.length()) {
            res.add(new LinkedList<String>(tmp));
            return;
        }
        for(int i=pos+1;i<=s.length();i++) {
            String cur = s.substring(pos, i);
            if(valid(cur)) {
                tmp.add(cur);
                find(res, tmp, i, s);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    public boolean valid(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l<=r) {
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}