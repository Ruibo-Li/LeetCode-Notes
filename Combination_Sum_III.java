public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<List<Integer>> ();
        List<Integer> list = new LinkedList<Integer> ();
        helper(res, k, n, 1, list);
        return res;
    }
    public void helper(List<List<Integer>> res, int k, int left, int cur, List<Integer> list) {
        if(left<0) 
            return;
        if(k==0) {
            if(left==0) 
                res.add(new LinkedList(list));
            return;
        }
        for(int i=cur;i<10;i++) {
            List <Integer> tmp = new LinkedList<Integer> (list);
            tmp.add(i);
            helper(res, k-1, left-i, i+1, tmp);
        }
        return;
    }
}