public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        List<Integer> tmp = new ArrayList<Integer> ();
        helper(candidates,target,0,res,tmp);
        return res;
    }
    public void helper(int[] candidates,int target,int index,List<List<Integer>> res,List<Integer> tmp){
        if(target<0||index==candidates.length) return;
        if(target==0){
            res.add(new ArrayList<Integer> (tmp));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>0&&candidates[i]==candidates[i-1]) continue;
            tmp.add(candidates[i]);
            helper(candidates,target-candidates[i],i,res,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}