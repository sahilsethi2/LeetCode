class Solution {
    public void gameOfLife(int[][] board) {
        int[] dr = new int[]{-1,-1,-1,0,0,1,1,1};
        int[] dc = new int[]{-1,0,1,-1,1,-1,0,1};
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                int cnt = 0;
                for(int idx=0; idx<8; idx++){
                    int nr = i+dr[idx];
                    int nc = j+dc[idx];
                    if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length){
                        if(board[nr][nc]==1 || board[nr][nc]==2) cnt++;
                    }
                }
                if (board[i][j] == 1){
                    if(cnt<2||cnt>3){
                        board[i][j]=2;
                    }
                }
                else{
                    if(cnt==3){
                        board[i][j]=3;
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 2) board[i][j] = 0;
                else if(board[i][j] == 3) board[i][j] = 1;
            }
        }
    }
}