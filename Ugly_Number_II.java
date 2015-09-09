public class Solution {
    public int nthUglyNumber(int n) {
        LinkedList<Integer> l1 = new LinkedList<Integer>();
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        LinkedList<Integer> l3 = new LinkedList<Integer>();
        l1.add(1);
        l2.add(1);
        l3.add(1);
        int u = 1;
        for(int i=0;i<n;i++) {
            u = Math.min(Math.min(l1.get(0), l2.get(0)), l3.get(0));
            if(l1.get(0)==u)
                l1.remove(0);
            if(l2.get(0)==u)
                l2.remove(0);
            if(l3.get(0)==u)
                l3.remove(0);
            l1.add(u*2);
            l2.add(u*3);
            l3.add(u*5);
        }
        return u;
    }
}