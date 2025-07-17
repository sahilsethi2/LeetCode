class Solution {
    public int removePalindromeSub(String s) {
        if(isPalin(s)) return 1;
        else return 2;
    }
    private boolean isPalin(String s) {
        int i=0, j= s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
    
    // public int removePalindromeSub(String s) {
    //     String rev = new StringBuilder(s).reverse().toString();
    //     int[][] dp = new int[s.length()+1][s.length()+1];
    //     for(int i = 0; i < s.length()+1; i++){
    //         Arrays.fill(dp[i],-1);
    //     }
    //     int lcsl = lcs(s,rev,s.length(),s.length(),dp);
    //     return 1+s.length()-lcsl;
    // }
    // public int lcs(String x,String y,int m, int n,int[][] dp){
    //     if(m==0||n==0) return 0;
    //     if(dp[m][n]!=-1)return dp[m][n];
    //     if(x.charAt(m-1)==y.charAt(n-1)) return dp[m][n]=1+lcs(x,y,m-1,n-1,dp);
    //     else{
    //         return dp[m][n] = Math.max(lcs(x,y,m-1,n,dp),lcs(x,y,m,n-1,dp));
    //     }
    // }
}