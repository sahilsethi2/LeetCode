class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public void bfs(int r, int c, char[][] grid, boolean[][] vis){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(r,c));
        vis[r][c] = true;
        int m = grid.length;
        int n = grid[0].length;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int f = q.peek().first;
            int s = q.peek().second;
            q.poll();
            for(int i=0; i<4; i++){ //four directions
                    int nrow = f + drow[i];
                    int ncol = s + dcol[i];
                    if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]=='1' && vis[nrow][ncol] == false){
                        vis[nrow][ncol] = true;
                        q.add(new Pair(nrow,ncol));
                    }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int cnt = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(vis[i][j] == false && grid[i][j] == '1'){
                    cnt++;
                    bfs(i,j,grid,vis);
                }
            }
        }
        return cnt;
    }
}