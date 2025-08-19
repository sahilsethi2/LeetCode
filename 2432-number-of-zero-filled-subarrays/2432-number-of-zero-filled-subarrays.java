class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans=0;
        int cnt=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                cnt++;
                ans+=cnt;
            }
            else cnt=0;
        }
        return ans;
    }
}