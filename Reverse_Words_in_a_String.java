public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int i = 0;
        List<String> rec = new LinkedList<String>();
        while(i<s.length()) {
            int start = i;
            while(i<s.length()&&s.charAt(i)!=' ')
                i++;
            rec.add(s.substring(start, i));
            while(i<s.length()&&s.charAt(i)==' ')
                i++;
        }
        StringBuilder sb = new StringBuilder();
        for(int j=rec.size()-1;j>=0;j--){
            sb.append(rec.get(j));
            if(j!=0)
                sb.append(' ');
        }
        return sb.toString();
    }
}