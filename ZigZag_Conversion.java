public class Solution {
    public String convert(String s, int nRows) {
        int l = s.length();
        if(nRows==1||nRows>=l) return s;
        String res = "";
        int dif = 2*nRows-2;
        for(int i=0;i<nRows;i++){
            for(int index=i;index<l;index+=dif){
                res = res+s.charAt(index);
                if(i!=0&&i!=nRows-1&&index+dif-2*i<l) res=res+s.charAt(index+dif-2*i);
            }
        }
        return res;
    }
}