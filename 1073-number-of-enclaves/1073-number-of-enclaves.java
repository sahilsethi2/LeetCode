class Solution {
    public void dfs(int row, int col, int[][] grid, boolean[][] vis){
        vis[row][col] = true;
        int m = grid.length;
        int n = grid[0].length;
        int[] delrow = {-1,0,+1,0};
        int[] delcol = {0,+1,0,-1};
        for(int i =0; i < 4; i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==1 && vis[nrow][ncol] == false){
                dfs(nrow, ncol, grid, vis);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0;  i<m; i++){
            if(grid[i][0] == 1 && vis[i][0]==false){
                dfs(i,0,grid,vis);
            }
            if(grid[i][n-1] == 1 && vis[i][n-1]==false){
                dfs(i,n-1,grid,vis);
            }
        }
        for(int j = 0;  j<n; j++){
            if(grid[0][j] == 1 && vis[0][j]==false){
                dfs(0,j,grid,vis);
            }
            if(grid[m-1][j] == 1 && vis[m-1][j]==false){
                dfs(m-1,j,grid,vis);
            }
        }
        int cnt = 0;
        for(int i = 1; i < m-1; i++){
            for(int j = 1; j < n-1; j++){
                if(vis[i][j] == false && grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}