class Solution {
    int mod = (int)1e9+7;
    int[][] t = new int[301][301];
    public int solve(int n , int num, int x){
        if(n==0) return 1; //path found
        if(n<0) return 0;
        int curr = (int)Math.pow(num,x);
        if(curr > n) return 0;

        if(t[n][num] != -1) return t[n][num];
        int take = solve(n-curr , num+1, x);
        int skip = solve(n, num+1, x);
        return t[n][num] = (take+skip)%mod;
    }
    public int numberOfWays(int n, int x) {
        for(int[] i: t){
            Arrays.fill(i,-1);
        }
        return solve(n,1,x);
    }
}