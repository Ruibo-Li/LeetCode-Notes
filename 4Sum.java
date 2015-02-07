public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        HashSet<List<Integer>> set = new HashSet<List<Integer>> ();
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        for(int i=0;i<num.length;i++){
            for(int j=i+1;j<num.length;j++){
                int l = j+1;
                int k = num.length-1;
                while(l<k){
                    int sum = num[i]+num[j]+num[l]+num[k];
                    if(sum<target) l++;
                    else if(sum>target) k--;
                    else if(sum==target){
                        List<Integer> tmp = new ArrayList<Integer> ();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[l]);
                        tmp.add(num[k]);
                        if(!set.contains(tmp)){
                            set.add(tmp);
                            res.add(tmp);
                        }
                        l++;
                        k--;
                    }
                }
            }
        }
        return res;
    }
}