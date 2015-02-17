public class Solution {
    public String minWindow(String S, String T) {
        String res = "";
        HashMap <Character,Integer> dict = new HashMap <Character,Integer> ();
        for(int i=0;i<T.length();i++) {
            char cur = T.charAt(i);
            if(dict.containsKey(cur))
                dict.put(cur,dict.get(cur)+1);
            else
                dict.put(cur,1);
        }
        HashMap <Character,Integer> found = new HashMap <Character,Integer> ();
        int end = 0;
        int start = 0;
        int counter = 0;
        int min = Integer.MAX_VALUE;
        while(end<S.length()) {
            char cur = S.charAt(end);
            if(dict.containsKey(cur)) {
                if(found.containsKey(cur)) {
                    if(found.get(cur)<dict.get(cur)) counter++;
                    found.put(cur,found.get(cur)+1);
                }
                else{
                    found.put(cur,1);
                    counter++;
                }
            }
            if(counter==T.length()) {
                char re = S.charAt(start);
                while(!found.containsKey(re)||found.get(re)>dict.get(re)) {
                    if(found.containsKey(re)&&found.get(re)>dict.get(re))
                        found.put(re,found.get(re)-1);
                    start++;
                    re = S.charAt(start);
                }
                if(end-start+1<min) {
                    min = end-start+1;
                    res = S.substring(start,end+1);
                }
            }
            end++;
        }
        return res;
    }
}