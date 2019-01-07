class TicTacToe {
   private static int [][] board;
    private static int N;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board=new int [2*n+2][2];
        N=n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
       
        if(board[row][player-1]==N-1) return player;
         board[row][player-1]++;
        
        if(board[col+N][player-1]==N-1) return player;
        board[col+N][player-1]++;
        if(row==col){
             if(board[2*N][player-1]==N-1) return player;
            board[2*N][player-1]++;
           
        }
        if(row==N-1-col)
        {
            if(board[2*N+1][player-1]==N-1) return player;
            board[2*N+1][player-1]++;
            
        }
        return 0;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
