public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if(num==null||num.length==0) return res;
        Arrays.sort(num);
        for(int i=0;i<num.length;i++){
            if(i>0&&num[i]==num[i-1]) continue;
            int l = i+1;
            int r = num.length-1;
            while(r>l){
                if(num[l]+num[r]==-num[i]){
                    List<Integer> tmp = new ArrayList<Integer> ();
                    tmp.add(num[i]);
                    tmp.add(num[l]);
                    tmp.add(num[r]);
                    res.add(tmp);
                    l++;
                    while(l<r&&num[l]==num[l-1]) l++;
                    r--;
                    while(l<r&&num[r]==num[r+1]) r--;
                }
                else if(num[l]+num[r]<-num[i]){
                    l++;
                    while(l<r&&num[l]==num[l-1]) l++;
                } 
                else{
                    r--;
                    while(l<r&&num[r]==num[r+1]) r--;
                }
            }
        }
        return res;
    }
}