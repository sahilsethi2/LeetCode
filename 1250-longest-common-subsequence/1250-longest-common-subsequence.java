class Solution {
    public int lcs(String x,String y, int m , int n ){
        if(m==0 || n==0) return 0;
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i<m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        return lcs(text1, text2, m, n);
    }
}









// class Solution {
//     int lcs(String x, String y, int m, int n){
//         if(m==0||n==0) return 0;
//         int[][] dp = new int[m+1][n+1];
//         for(int i=0; i<m+1;i++){
//             for(int j=0; j<n+1;j++){
//                 if(i==0||j==0) dp[i][j]=0;
//             }
//         }
//         for(int i = 1; i<m+1;i++){
//             for(int j = 1; j<n+1; j++){
//                 if(x.charAt(i-1)==y.charAt(j-1)){
//                     dp[i][j] = 1+dp[i-1][j-1];
//                 }else{
//                     dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
//                 }
//             }
//         }
//         return dp[m][n];
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length();
//         int n = text2.length();
        
//         return lcs(text1,text2,m,n);
//     }
// }









// class Solution {
//     static int[][] t = new int[1001][1001];
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length();
//         int n = text2.length();
//         for (int i = 0; i < m+1; i++) {
//             Arrays.fill(t[i], -1);
//         }
//         return lcs(text1,text2,m,n);
//     }
//     public int lcs(String x, String y, int m, int n){
//         if(m == 0 || n == 0) return 0;
//         if(t[m][n]!=-1) return t[m][n];
//         if(x.charAt(m-1) == y.charAt(n-1)) return t[m][n] = 1+lcs(x,y,m-1,n-1);
//         else{
//             return t[m][n] = Math.max(lcs(x,y,m,n-1), lcs(x,y,m-1,n));
//         }
//     }
// }

// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int m = text1.length();
//         int n = text2.length();
//         int[][] dp = new int[m + 1][n + 1];
//         for (int i = 1; i<m+1; i++){
//             for (int j = 1; j<n+1; j++){
//                 if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 } else {
//                     dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
//                 }
//             }
//         }
//         return dp[m][n];
//     }
// }