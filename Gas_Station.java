public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        for(int i=0;i<gas.length;i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if(gasSum<costSum)  
            return -1;
        int start = 0;
        int rem = 0;
        for(int i=0;i<gas.length;i++) {
            if(rem+gas[i]<cost[i])
                start = i+1;
            else
                rem += (gas[i]-cost[i]);
        }
        return start;
    }
}