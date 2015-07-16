public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List <String> res = new LinkedList <String> ();
        int last = 0;
        int count = 0;
        int spaceNum = 0;
        int extraNum = 0;
        for(int i=0;i<words.length;i++) {
            if(count+words[i].length()+i-last>maxWidth) {
                if(i-last-1>0) {
                    spaceNum = (maxWidth-count)/(i-last-1);
                    extraNum = (maxWidth-count)%(i-last-1);
                }
                StringBuilder sb = new StringBuilder();
                for(int j=last;j<i;j++) {
                    sb.append(words[j]);
                    if(j<i-1) {
                        for(int k=0;k<spaceNum;k++)
                            sb.append(' ');
                        if(extraNum>0) {
                            sb.append(' ');
                            extraNum--;
                        }
                    }
                }
                for(int j=sb.length();j<maxWidth;j++) 
                    sb.append(' ');
                res.add(sb.toString());
                count = 0;
                last = i;
            }
            count += words[i].length();
        }
        StringBuilder sb = new StringBuilder ();
        for(int i=last;i<words.length;i++) {
            sb.append(words[i]);
            if(sb.length()<maxWidth)
                sb.append(' ');
        }
        for(int i=sb.length();i<maxWidth;i++)
            sb.append(' ');
        res.add(sb.toString());
        return res;
    }
}