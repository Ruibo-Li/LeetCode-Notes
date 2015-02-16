public class Solution {
    public String addBinary(String a, String b) {
        ArrayList <Integer> rec = new ArrayList <Integer> ();
        int len = Math.min(a.length(),b.length());
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        int num = 0;
        while(i>=0&&j>=0) {
            int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + carry;
            int[] tmp = add(sum);
            num = tmp[0];
            carry = tmp[1];
            rec.add(0,num);
            i--;
            j--;
        }
        while(i>=0) {
            int sum = a.charAt(i) - '0'  + carry; 
            int[] tmp = add(sum);
            num = tmp[0];
            carry = tmp[1];
            rec.add(0,num);
            i--;
        }
        while(j>=0) {
            int sum = b.charAt(j) - '0'  + carry; 
            int[] tmp = add(sum);
            num = tmp[0];
            carry = tmp[1];
            rec.add(0,num);
            j--;
        }
        if(carry>0) rec.add(0,carry);
        StringBuilder res = new StringBuilder();
        for(int ele:rec)
            res.append(ele);
        return res.toString();
    }
    public int[] add(int sum) {
        int[] res = new int[2];
        if(sum == 0){
            res[0] = 0;
            res[1] = 0;
        }    
        else if(sum == 1){
            res[0] = 1;
            res[1] = 0;
        }
        else if(sum == 2){
            res[0] = 0;
            res[1] = 1;
        }
        else if(sum==3){
            res[0] = 1;
            res[1] = 1;
        }
        return res;
    }
}