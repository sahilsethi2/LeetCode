class Three{
    int row;
    int col;
    int time;
    public Three(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Three> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int cntf = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new Three(i,j,0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j]=0;
                }

                if(grid[i][j] == 1) cntf++;
            }
        }

        int[] delrow = {-1,0,+1,0};
        int[] delcol = {0,+1,0,-1};
        int t = 0;
        int cnt = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int tm = q.peek().time;
            q.poll();
            
            for(int i = 0; i < 4; i++){
                int nrow =  r + delrow[i];
                int ncol = c + delcol[i];
                t = Math.max(t, tm);
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol] == 1 && vis[nrow][ncol] != 2){
                    vis[nrow][ncol] = 2;
                    q.add(new Three(nrow,ncol,tm+1));
                    cnt++;
                }
            }
        }

        if(cnt != cntf) return -1;
        return t;
    }
}