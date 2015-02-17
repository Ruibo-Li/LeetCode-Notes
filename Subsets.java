public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        res.add(tmp);
        Arrays.sort(S);
        dfs(S,res,tmp,0);
        return res;
    }
    
    public void dfs(int[] S,List<List<Integer>> res,List<Integer> tmp,int pos){
        for(int i=pos;i<S.length;i++){
            tmp.add(S[i]);
            res.add(new ArrayList<Integer>(tmp));
            dfs(S,res,tmp,i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}