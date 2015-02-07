public class Solution {
    public int maximumGap(int[] num) {
        if(num==null||num.length<2) return 0;
        int min = num[0];
        int max = num[0];
        for(int i:num){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        int mingap = (int)Math.ceil((double)(max-min)/(num.length-1));
        int[] bucketmin = new int[num.length-1];
        int[] bucketmax = new int[num.length-1];
        Arrays.fill(bucketmin,Integer.MAX_VALUE);
        Arrays.fill(bucketmax,Integer.MIN_VALUE);
        for(int e:num){
            if(e==min||e==max) continue;
            int index = (e-min)/mingap;
            bucketmin[index] = Math.min(e,bucketmin[index]);
            bucketmax[index] = Math.max(e,bucketmax[index]);
        }
        int res = Integer.MIN_VALUE;
        int pre = min;
        for(int i=0;i<num.length-1;i++){
            if(bucketmin[i]==Integer.MAX_VALUE&&bucketmax[i]==Integer.MIN_VALUE) continue;
            res = Math.max(bucketmin[i]-pre,res);
            pre = bucketmax[i];
        }
        res = Math.max(max-pre,res);
        return res;
    }
}