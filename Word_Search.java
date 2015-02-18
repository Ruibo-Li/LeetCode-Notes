public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if(m==0) return false;
        int n = board[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(word.charAt(0)==board[i][j]) {
                    HashSet <Integer> set = new HashSet <Integer> ();
                    if(helper(board,word,i,j,0,set))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board,String word,int i,int j,int pos,HashSet <Integer> set)
    {
        if(board[i][j]!=word.charAt(pos)) return false;
        else {
            if(pos==word.length()-1) return true;
            set.add(i*board[0].length+j);
            boolean res = false;
            if(i>0 && !set.contains((i-1)*board[0].length+j))
                res = res||helper(board,word,i-1,j,pos+1,new HashSet<Integer>(set));
            if(i<board.length-1 && !set.contains((i+1)*board[0].length+j))
                res = res||helper(board,word,i+1,j,pos+1,new HashSet<Integer>(set));
            if(j>0 && !set.contains(i*board[0].length+j-1))
                res = res||helper(board,word,i,j-1,pos+1,new HashSet<Integer>(set));
            if(j<board[0].length-1 && !set.contains(i*board[0].length+j+1))
                res = res||helper(board,word,i,j+1,pos+1,new HashSet<Integer>(set));
            return res;
        }
    }
}