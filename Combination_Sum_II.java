public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        List<Integer> tmp = new ArrayList<Integer> ();
        helper(num,target,0,res,tmp);
        return res;
    }
    public void helper(int[] num,int target,int index,List<List<Integer>> res,List<Integer> tmp){
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList (tmp));
            return;
        }
        for(int i=index;i<num.length;i++){
            if(i>index&&num[i]==num[i-1]) continue;
            tmp.add(num[i]);
            helper(num,target-num[i],i+1,res,tmp);
            tmp.remove(tmp.size()-1);
        }
        return;
    }
}