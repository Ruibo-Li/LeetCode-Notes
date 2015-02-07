public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        HashSet<List<Integer>> reset = new HashSet<List<Integer>> ();
        Arrays.sort(num);
        helper(reset,num,0);
        List<List<Integer>> res = new ArrayList<List<Integer>> (reset);
        return res;
    }
    public void helper(HashSet<List<Integer>> reset,int[] num,int pos) {
        if(pos==num.length) {
            List<Integer> newlist = new ArrayList<Integer> ();
            for(int i=0;i<num.length;i++) newlist.add(num[i]);
            reset.add(newlist);
            return;
        }
        for(int i=pos;i<num.length;i++) {
            if(i!=pos&&num[i]==num[pos]) continue;
            int tmp = num[pos];
            num[pos] = num[i];
            num[i] = tmp;
            helper(reset,num,pos+1);
            num[i] = num[pos];
            num[pos] = tmp;
        }
    }
}