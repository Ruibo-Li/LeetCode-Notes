public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        if(k==0)
            return new int[0];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<nums.length;i++) {
            while(!queue.isEmpty()&&nums[i]>nums[queue.getLast()])
                queue.removeLast();
            queue.addLast(i);
            if(i-queue.getFirst()+1>k)
                queue.removeFirst();
            if(i+1>=k)
                res[i+1-k] = nums[queue.getFirst()];
        }
        return res;
    }
}