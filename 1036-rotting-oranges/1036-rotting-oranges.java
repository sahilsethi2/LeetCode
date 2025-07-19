class Pair{
    int row;
    int col;
    int tm;
    Pair(int _row,int _col, int _tm){
        this.row = _row;
        this.col = _col;
        this.tm = _tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        int[] delrow = {-1,0,+1,0};
        int[] delcol = {0,+1,0,-1};
        int time=0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            q.poll();
            time=Math.max(time, t);
            for(int i=0; i<4;i++){
                int nrow = r+delrow[i];
                int ncol = c+delcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=true;
                    grid[nrow][ncol]=2;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j]==1 && vis[i][j]==false){
                    return -1;
                }
            }
        }
        return time;
    }
}