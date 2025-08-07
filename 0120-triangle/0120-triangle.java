class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int j = 0; j < n; j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        for(int i = n-2; i>=0; i--){
            for(int j = 0; j<=i; j++){
                int down = dp[i+1][j];
                int diag = dp[i+1][j+1];
                dp[i][j] = triangle.get(i).get(j) + Math.min(down, diag);
            }
        }

        return dp[0][0];
    }
}










// class Solution {
//     public int f(List<List<Integer>> list, int i, int j, int n, int dp[][]) {
//         if(i == n-1) return list.get(i).get(j);
//         if(i>=n || j>i) return Integer.MAX_VALUE;
//         if (dp[i][j] != -1) {
//             return dp[i][j];
//         }
//         int curr = list.get(i).get(j);
//         int down = curr+ f(list, i+1, j, n, dp);
//         int digonal = curr + f(list, i+1, j+1, n, dp);
//         return dp[i][j] = Math.min(down, digonal);
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int n = triangle.size();
//         int dp[][] = new int[n][n];
//         for(int arr[] : dp){
//             Arrays.fill(arr, -1);
//         }
//         return f(triangle, 0, 0, n, dp);
//     }
// }