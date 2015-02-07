public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int res = num[0]+num[1]+num[2];
        int diff = Math.abs(res-target);
        for(int i=0;i<num.length;i++){
            int j = i+1;
            int k = num.length-1;
            while(j<k){
                int sum = num[i]+num[j]+num[k];
                int tmp = Math.abs(sum-target);
                if(tmp<diff){
                    res = sum;
                    diff = tmp;
                }
                if(sum<target) j++;
                else{
                    k--;
                }
            }
        }
        return res;
    }
}