public class Solution {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    public List<String> findRepeatedDnaSequences(String s) {
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<String> result = new HashSet<String>();
        for(int i=0;i<s.length()-9;i++) {
            String cur = s.substring(i,i+10);
            int curint = convert(cur);
            if(set.contains(curint)) 
                result.add(cur);
            else
                set.add(curint);
        }
        return new LinkedList<String>(result);
    }
    public int convert(String s) {
        int res = 0;
        for(int i=0;i<s.length();i++) 
            res = res*4+map.get(s.charAt(i));
        return res;
    }
}