public class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    public boolean helper(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(valid(board,i,j,c)){
                            board[i][j] = c;
                            if(helper(board)) return true;
                            else{
                                board[i][j] = '.';
                            }
                        } 
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean valid(char[][] board,int i,int j,char ct){
        for(int row=0;row<9;row++)
            if(board[row][j]==ct) return false;
        
        for(int col=0;col<9;col++)
            if(board[i][col]==ct) return false;
        
        for(int row=i/3*3;row<i/3*3+3;row++)
            for(int col=j/3*3;col<j/3*3+3;col++)
                if(board[row][col]==ct) return false;
            
        
        return true;
    }
}