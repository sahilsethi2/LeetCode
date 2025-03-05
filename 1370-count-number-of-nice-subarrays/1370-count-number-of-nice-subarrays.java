class Solution{
    public int numberOfSubarrays(int[] nums, int k) {
    return atMostK(nums, k) - atMostK(nums, k - 1);
}

private int atMostK(int[] nums, int k) {
    if (k < 0) return 0;
    
    int l = 0, r = 0, sum = 0, count = 0;
    
    while (r < nums.length) {
        sum += nums[r] % 2; // Count odd numbers
        
        while (sum > k) { // Shrink window if odd count exceeds k
            sum -= nums[l] % 2;
            l++;
        }
        
        count += (r - l + 1); // Count valid subarrays
        r++;
    }
    
    return count;
}
}