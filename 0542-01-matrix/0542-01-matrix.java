class Pair{
    int fir;
    int sec;
    int thi;
    public Pair(int fir, int sec, int thi){
        this.fir = fir;
        this.sec = sec;
        this.thi = thi;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dist = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i <m; i++){
            for(int j=0; j<n;j++){
                if(grid[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = true;
                }
            }
        }

        int[] delrow = {-1,0,+1,0};
        int[] delcol = {0,+1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().fir;
            int col = q.peek().sec;
            int steps = q.peek().thi;
            q.poll();
            dist[row][col] =steps;


            for(int i = 0; i < 4; i++){
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol < n && vis[nrow][ncol] == false){
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow,ncol,steps+1));
                }
            }
        }
        return dist;
    }
}