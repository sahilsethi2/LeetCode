class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int index = 0;
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = nums[i]*nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}