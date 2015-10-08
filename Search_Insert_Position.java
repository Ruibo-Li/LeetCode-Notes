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
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(len==0) return 0;
        int l = 0;
        int r = len-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>target) r = mid-1;
            if(nums[mid]<target) l = mid+1;
        }
        return l;
    }
}