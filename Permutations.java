public class Solution {
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> rs = new ArrayList<List<Integer>> ();
        helper(rs,0,num);
        return rs;
    }  
    
    public void helper(List<List<Integer>> rs,int index,int[] num){
        if(index==num.length){
            List<Integer> ele = new ArrayList<Integer>();
            for(int i=0;i<num.length;i++) ele.add(num[i]);
            rs.add(ele);
        }
        
        for(int i=index;i<num.length;i++){
            int tmp = num[index];
            num[index] = num[i];
            num[i] = tmp;
            helper(rs,index+1,num);
            num[i] = num[index];
            num[index] = tmp;
        }
    }
      
    }