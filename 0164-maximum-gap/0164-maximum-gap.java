class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length<2) return 0;
        Arrays.sort(nums);
        int diff=Integer.MIN_VALUE;
        for(int i = 1; i<nums.length; i++){
            diff = Math.max(diff,nums[i]-nums[i-1]);
        }
        return diff;
    }
}