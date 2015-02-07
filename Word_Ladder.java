public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(dict.size()==0) return 0;
        LinkedList<String> words = new LinkedList<String> ();
        LinkedList<Integer> dis = new LinkedList<Integer> ();
        words.add(start);
        dis.add(1);
        while(!words.isEmpty()){
            String curword = words.pop();
            Integer curdis = dis.pop();
            if(curword.equals(end)) return curdis;
            for(int i=0;i<curword.length();i++){
                char[] chars = curword.toCharArray();
                for(char c='a';c<='z';c++){
                    chars[i] = c;
                    String tmp = new String(chars);
                    if(dict.contains(tmp)){
                        words.add(tmp);
                        dis.add(curdis+1);
                        dict.remove(tmp);
                    }
                }
            }
        }
        return 0;
    }
}