class Tuple{
    int difference;
    int row;
    int col;
    public Tuple(int difference, int row, int col){
        this.difference = difference;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((a,b)->a.difference-b.difference);
        int[][] distance = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j=0;j<n; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = 0;
        int[] dr = {-1,0,+1,0};
        int[] dc = {0,+1,0,-1};
        pq.add(new Tuple(0,0,0));
        while(!pq.isEmpty()){
            Tuple t = pq.poll();
            int diff = t.difference; int r = t.row; int c = t.col;
            if(r==m-1 && c==n-1) return diff;
            for(int i = 0; i < 4; i++){
                int nrow = r + dr[i];
                int ncol = c + dc[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n){
                    int newEff = Math.max(Math.abs(heights[r][c]-heights[nrow][ncol]), diff);
                    if(newEff < distance[nrow][ncol]){
                        distance[nrow][ncol] = newEff;
                        pq.add(new Tuple(newEff,nrow,ncol));
                    }
                }
            }
        }
        return 0;
    }
}