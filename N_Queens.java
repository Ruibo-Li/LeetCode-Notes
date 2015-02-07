public class Solution {
    public List<String[]> solveNQueens(int n) {
        List <String[]> res = new ArrayList <String[]> ();
        int[] loc = new int[n];
        helper(res,loc,0,n);
        return res;
    }
    public void helper(List<String[]> res,int[] loc,int cur,int n) {
        if(cur==n) {
            print(res,loc);
            return;
        }
        for(int i=0;i<n;i++) {
            if(valid(i,cur,loc)) {
                loc[cur] = i;
                helper(res,loc,cur+1,n);
            }
        }
    }
    public boolean valid(int pos,int cur,int[] loc) {
        for(int i=0;i<cur;i++) {
            if(loc[i]==pos) return false;
            if(Math.abs(pos-loc[i])==cur-i) return false;
        }
        return true;
    }
    public void print(List<String[]> res,int[] loc) {
        String[] rows = new String[loc.length];
        for(int i=0;i<loc.length;i++) {
            rows[i] = "";
            for(int j=0;j<loc.length;j++) {
                if(j==loc[i]) rows[i] += 'Q';
                else
                    rows[i] += '.';
            }
        }
        res.add(rows);
    }
}