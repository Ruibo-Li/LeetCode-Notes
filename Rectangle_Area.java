public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int width1 = C-A;
        int width2 = G-E;
        int height1 = D-B;
        int height2 = H-F;
        
        int startX = Math.min(A, E);
        int endX = Math.max(C, G);
        int width = width1+width2-(endX-startX);
        
        int startY = Math.min(B, F);
        int endY = Math.max(D, H);
        int height = height1+height2-(endY-startY);
        
        int area = 0;
        if(width>0&&height>0)
            area = width*height;
        int area1 = width1*height1;
        int area2 = width2*height2;
        return area1+area2-area;
    }
}