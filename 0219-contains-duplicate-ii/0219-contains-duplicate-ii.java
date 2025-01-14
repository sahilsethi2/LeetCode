class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> indexMap = new HashMap<>(); // Store the last index of each number
        
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i]) && i - indexMap.get(nums[i]) <= k) {
                return true; // Found a pair that satisfies the condition
            }
            indexMap.put(nums[i], i); // Update the index of the current number
        }
        
        return false; // No pair satisfies the condition
    }
}