public class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex+1];
        res[0] = 1;
        for(int i=1;i<=rowIndex;i++){
            res[i] = 1;
            for(int j=i-1;j>0;j--){
                res[j] = res[j]+res[j-1];
            }
        }
        return new ArrayList<Integer>(Arrays.asList(res));
    }
}