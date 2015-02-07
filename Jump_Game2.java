public class Solution {
    public int jump(int[] A) {
        int l = A.length;
        if(l<=1) return 0;
        int lastCover = 0;
        int maxCover = 0;
        int step = 0;
        for(int i=0;i<=maxCover&&i<l;i++){
            if(i>lastCover){
                step++;
                lastCover = maxCover;
            }
            maxCover = Math.max(maxCover,i+A[i]);
        }
        if(maxCover>=l-1) return step;
        else{
            return -1;
        }
}
}