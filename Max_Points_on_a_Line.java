/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length==0)
            return 0;
        int res = 1;
        for(int i=0;i<points.length;i++) {
            Point a = points[i];
            int same = 0;
            int localmax = 1;
            HashMap<Float, Integer> map = new HashMap<Float, Integer>();
            for(int j=0;j<points.length;j++) {
                if(j==i)
                    continue;
                Point b = points[j];
                if(b.y==a.y&&b.x==a.x) {
                    same++;
                    continue;
                }
                float kv = (float)(b.y-a.y)/(b.x-a.x);
                if(map.containsKey(kv))
                    map.put(kv, map.get(kv)+1);
                else
                    map.put(kv, 2);
            }
            for(Integer num: map.values())
                localmax = Math.max(num, localmax);
            localmax += same;
            res = Math.max(localmax, res);
        }
        return res;
    }
}