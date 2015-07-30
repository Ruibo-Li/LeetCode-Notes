public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        String sign = "";
        if(numerator<0&&denominator>0||numerator>0&&denominator<0)
            sign = "-";
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long major = num/den;
        long rem = num%den;
        if(rem==0)
            return sign+major;
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        StringBuilder res = new StringBuilder(sign+major+'.');
        while(rem!=0) {
            if(map.containsKey(rem)) {
                int index = map.get(rem);
                res.insert(index, '(');
                res.append(')');
                break;
            }
            else {
                map.put(rem, res.length());
                res.append(rem*10/den);
            }
            rem = rem*10%den;
        }
        return res.toString();
    }
}