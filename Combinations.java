public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if(n<=0||n<k) return res;
        List<Integer> tmp = new ArrayList<Integer> ();
        helper(n,k,1,res,tmp);
        return res;
    }
    public void helper(int n,int k,int start,List<List<Integer>> res,List<Integer> tmp){
        if(tmp.size()==k){
            res.add(new ArrayList<Integer> (tmp));
            return;
        }
        for(int i=start;i<=n;i++){
            tmp.add(i);
            helper(n,k,i+1,res,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}