class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length() ;
        int n = text2.length() ;
        dp = new int[m+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return lcs(text1, text2, m-1, n-1, dp ) ;
    }
    public int lcs (String t1, String t2, int m, int n, int[][] dp){
        
        if(m < 0 || n < 0) return 0 ;
        if(dp[m][n] != -1) return dp[m][n];
        if(t1.charAt(m) == t2.charAt(n))  return dp[m][n] = 1+lcs(t1,t2,m-1,n-1,dp) ;
        return dp[m][n] = Math.max(
            lcs(t1,t2,m,n-1,dp), lcs(t1,t2,m-1,n,dp)
        );
    }
}