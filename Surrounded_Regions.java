public class Solution {
    public void solve(char[][] board) {
        if(board==null||board.length<=1||board[0].length<=1) return;
        for(int i=0;i<board.length;i++){
            fill(board,i,0);
            fill(board,i,board[0].length-1);
        }
        for(int i=0;i<board[0].length;i++){
            fill(board,0,i);
            fill(board,board.length-1,i);
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O') board[i][j] = 'X';
                if(board[i][j]=='F') board[i][j] = 'O';
            }
        }
        return;
    }
    
    public void fill(char[][] board,int i,int j){
        if(board[i][j]!='O') return;
        board[i][j] = 'F';
        LinkedList<Integer> queue = new LinkedList<Integer> ();
        queue.add(i*board[0].length+j);
        while(!queue.isEmpty()){
            int cur = queue.pop();
            int row = cur/board[0].length;
            int col = cur%board[0].length;
            if(row>0&&board[row-1][col]=='O'){
                board[row-1][col]='F';
                queue.add((row-1)*board[0].length+col);
            } 
            if(row<board.length-1&&board[row+1][col]=='O'){
                board[row+1][col]='F';
                queue.add((row+1)*board[0].length+col);
            } 
            if(col>0&&board[row][col-1]=='O'){
                board[row][col-1]='F';
                queue.add((row*board[0].length+col-1));
            } 
            if(col<board[0].length-1&&board[row][col+1]=='O'){
                board[row][col+1]='F';
                queue.add((row*board[0].length+col+1));
            } 
        }
        return;
    }
}