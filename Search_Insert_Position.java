public class Solution {
    public int searchInsert(int[] A, int target) {
        int l = A.length;
        if(l==0) return 0;
        int index = 0;
        while(index<l){
            if(A[index]<target) index++;
            else{
                return index;
            } 
        }
        return l;
    }
}


public class Solution {
    public int searchInsert(int[] A, int target) {
        int len = A.length;
        if(len==0) return 0;
        int l = 0;
        int r = len-1;
        while(l<=r){
            if(A[l]>target) return l;
            if(A[r]<target) return r+1;
            int mid = (l+r)/2;
            if(A[mid]==target) return mid;
            if(A[mid]>target) r = mid-1;
            if(A[mid]<target) l = mid+1;
        }
        return 0;
    }
}