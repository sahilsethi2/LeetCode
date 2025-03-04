class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxi = 1;
        int incr=1, decr=1;
        for(int i=1; i<nums.length; i++){
            
                if(nums[i]-nums[i-1] > 0){
                    incr++;
                    decr=1;
                }
                else if(nums[i]-nums[i-1]<0){
                    decr++;
                    incr=1;
                }else{
                    decr = 1;
                    incr = 1;
                }
                maxi = Math.max(Math.max(incr, decr), maxi);
        }
        return maxi;
    }
}