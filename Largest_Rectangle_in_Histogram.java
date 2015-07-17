public class Solution {
    public int largestRectangleArea(int[] height) {
        int[] h = Arrays.copyOf(height, height.length+1);
        int i = 0;
        Stack <Integer> st = new Stack <Integer> ();
        int res = h[0];
        while(i<=height.length) {
            if(st.isEmpty()||h[i]>=h[st.peek()])
                st.push(i++);
            else {
                int s = st.pop();
                res = Math.max(res, h[s]*(st.isEmpty()?i:i-st.peek()-1));
            }
        }
        return res;
    }
}