public class Solution {
    public void nextPermutation(int[] num) {
        if(num==null||num.length==0) return;
        int i;
        for(i=num.length-2;i>=0;i--){
            if(num[i]<num[i+1]) break;
        }
        if(i>=0){
            int j = i+1;
            while(j<num.length&&num[j]>num[i]) j++;
            j--;
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }
        reverse(num,i+1);
        return;
    }
    
    public void reverse(int[] num,int index){
        int l = index;
        int r = num.length-1;
        while(l<r){
            int tmp = num[l];
            num[l] = num[r];
            num[r] = tmp;
            l++;
            r--;
        }
        return;
    }
}