public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int i = citations.length;
        for(int val: citations) {
            i--;
            if(val>i)
                h++;
        }
        return h;
    }
}