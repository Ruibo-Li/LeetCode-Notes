public class Solution {
    public int atoi(String str) {
        if(str==null||str.length()==0) return 0;
        long res = 0;
        boolean flag = false;
        str = str.trim();
        int i = 0;
        if(str.charAt(0)=='+') i++;
        if(str.charAt(0)=='-'){
            flag = true;
            i++;
        }
        for(;i<str.length();i++){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                res = res*10+(str.charAt(i)-'0');
                if(res>Integer.MAX_VALUE&&!flag) return Integer.MAX_VALUE;
                if(-res<Integer.MIN_VALUE&&flag) return Integer.MIN_VALUE;
            }
            else{
                break;
            }
        }
        if(flag) res = -res;
        return (int) res;
    }
}