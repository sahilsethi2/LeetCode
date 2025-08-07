class Solution {
    public int f(int i, int j, int m, int n, int[][] grid, int[][] dp){
        if(i==m-1 && j==n-1) return grid[i][j];
        if(i>=m || j>=n) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        int down = f(i+1,j,m,n,grid,dp);
        int right = f(i,j+1,m,n,grid,dp);
        return dp[i][j] = grid[i][j] + Math.min(down,right);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return f(0,0,m,n,grid,dp);
    }
}