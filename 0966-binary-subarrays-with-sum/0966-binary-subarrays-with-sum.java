class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countSubarrays(nums, goal) - countSubarrays(nums, goal - 1);
    }

    private int countSubarrays(int[] nums, int k) {
        int l = 0, sum = 0, count = 0;
        
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            
            while (l <= r && sum > k) { // Shrink the window when sum exceeds k
                sum -= nums[l];
                l++;
            }
            
            count += (r - l + 1); // Count all valid subarrays ending at r
        }
        
        return count;
    }
}
