class Solution {
    public int f(int i, int j, int m , int n, int[][] grid,int[][] dp){
        if(i==m-1 && j==n-1) return 1;
        if(i>m-1 || j>n-1 || grid[i][j] == 1) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int down = f(i+1,j,m,n,grid,dp);
        int right = f(i,j+1,m,n,grid,dp);
        return dp[i][j] = down + right;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length; 
        int n = grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1) return 0;
        int[][] dp = new int[m][n];
        for(int[] i : dp){
            Arrays.fill(i, -1);
        }
        return f(0,0,m,n,grid,dp);
    }
}