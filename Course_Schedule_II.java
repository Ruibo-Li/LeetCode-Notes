public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        int[] preCourse = new int[numCourses];
        for(int i=0;i<len;i++)
            preCourse[prerequisites[i][0]]++;
        LinkedList <Integer> queue = new LinkedList <Integer> ();
        int count = 0;
        int[] res = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            if(preCourse[i]==0) {
                res[count] = i;
                count++;
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int cur = queue.remove();
            for(int i=0;i<len;i++) {
                if(cur==prerequisites[i][1]) {
                    preCourse[prerequisites[i][0]]--;
                    if(preCourse[prerequisites[i][0]]==0) {
                        res[count] = prerequisites[i][0];
                        count++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        if(count==numCourses)
            return res;
        return new int[0];
    }
}