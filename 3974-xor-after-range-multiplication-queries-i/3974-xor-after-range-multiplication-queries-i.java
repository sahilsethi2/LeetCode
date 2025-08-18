class Solution {
    int mod=(int)1e9+7;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for( int i=0;i<queries.length;i++){
            int[] it=queries[i] ; 
            int l=it[0] , r=it[1] , k=it[2] , v=it[3] ;
            for(int j=l;j<=r;j+=k){
                long val= (1L*nums[j]*v)%mod ;
                nums[j] = (int)val; 
            }
        }
        int xo=0 ; 
        for(int it : nums){
            xo^=it  ; 
        }
        return xo ; 
    }
}