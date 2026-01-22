class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] lsum = new int[n];
        int[] rsum = new int[n];
        int l=nums[0],r=nums[n-1];
        lsum[0]=0; rsum[n-1]=0;
        for(int i=1; i<n; i++){
            lsum[i]=l;
            l+=nums[i];
        }
        for(int i=n-2; i>=0; i--){
            rsum[i]=r;
            r+=nums[i];
        }

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = Math.abs(lsum[i]-rsum[i]);
        }
        return ans;
    }
}