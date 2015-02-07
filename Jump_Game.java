public class Solution {
    public boolean canJump(int[] A) {
        int maxCover = 0;
        for(int start=0;start<A.length&&start<=maxCover;start++){
            maxCover = Math.max(maxCover,start+A[start]);
            if(maxCover>=A.length-1) return true;
        }
        return false;
    }
}