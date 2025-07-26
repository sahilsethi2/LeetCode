class Tuple{
    int dis; int row; int col;
    public Tuple(int dis, int row, int col){
        this.dis = dis;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1] == 1) return -1;
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(1,0,0));
        boolean vis[][] = new boolean[n][n];
        vis[0][0]=true;
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
        while(!q.isEmpty()){
            int dis = q.peek().dis;
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            if(row == n-1 && col==n-1) return dis;
            
            for(int i =0; i<8; i++){
                int nr = row+ dr[i];
                int nc = col+ dc[i];
                
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0 && vis[nr][nc]==false){
                    vis[nr][nc]=true;
                    q.add(new Tuple(dis+1,nr, nc));
                }
            }
        }
        return -1;
    }
}