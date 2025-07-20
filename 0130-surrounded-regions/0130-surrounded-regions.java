class Solution {
    public void dfs(int row, int col, boolean[][] vis,char[][] mat){
        vis[row][col] = true;
        int m = mat.length;
        int n = mat[0].length;
        int[] delrow = {-1,0,+1,0};
        int[] delcol = {0,+1,0,-1};
        for(int i = 0; i < 4; i++){
            int nrow = row+delrow[i];
            int ncol = col+delcol[i];
            if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && mat[nrow][ncol]=='O' && vis[nrow][ncol]==false){
                dfs(nrow,ncol,vis,mat);
            }
        }
    }
    public char[][] solve(char[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            if(mat[i][0]=='O' && vis[i][0]==false){
                dfs(i,0,vis,mat);
            }
            if(mat[i][n-1]=='O' && vis[i][n-1]==false){
                dfs(i,n-1,vis,mat);
            }
        }
        for(int j = 0; j < n; j++){
            if(mat[0][j]=='O' && vis[0][j]==false){
                dfs(0,j,vis,mat);
            }
            if(mat[m-1][j]=='O' && vis[m-1][j]==false){
                dfs(m-1,j,vis,mat);
            }
        }
        for(int i =0; i<m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 'O' && vis[i][j]==false){
                    mat[i][j] = 'X';
                }
            }
        }
        return mat;
    }
}