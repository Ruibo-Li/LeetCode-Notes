public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] pres = new int[numCourses];
        for(int i=0;i<numCourses;i++)
            pres[i] = 0;
        for(int[] pair: prerequisites) {
            pres[pair[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++) {
            if(pres[i]==0)
                queue.add(i);
        }
        while(!queue.isEmpty()) {
            int cur = queue.removeFirst();
            for(int[] pair: prerequisites) {
                if(pair[1]==cur) {
                    pres[pair[0]]--;
                    if(pres[pair[0]]==0)
                        queue.add(pair[0]);
                }
            }
        }
        for(int i:pres)
            if(i!=0)
                return false;
        return true;
    }
}