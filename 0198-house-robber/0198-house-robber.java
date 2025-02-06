class Solution {
    int func(int index, int[] arr, int[] dp) {
        if (index == 0) return arr[index];
        if (index < 0) return 0;

        if (dp[index] != -1) return dp[index];

        int pick = arr[index] + func(index - 2, arr, dp);
        int nonpick = func(index - 1, arr, dp);

        return dp[index] = Math.max(pick, nonpick);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return func(n - 1, nums, dp);
    }
}