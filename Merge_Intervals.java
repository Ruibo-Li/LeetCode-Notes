/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals,new intervalComparator());
        List <Interval> res = new ArrayList <Interval> ();
        if(intervals==null||intervals.size()==0) return res;
        Interval pre = intervals.get(0);
        for(int i=1;i<intervals.size();i++) {
            Interval cur = intervals.get(i);
            if(pre.end>=cur.start) {
                Interval newi = new Interval(pre.start,Math.max(pre.end,cur.end));
                pre = newi;
            }
            else {
                res.add(pre);
                pre = cur;
            }
        }
        res.add(pre);
        return res;
    }
    
    public class intervalComparator implements Comparator <Interval> {
        public int compare(Interval i1,Interval i2) {
            return i1.start - i2.start;
        }
    }
}