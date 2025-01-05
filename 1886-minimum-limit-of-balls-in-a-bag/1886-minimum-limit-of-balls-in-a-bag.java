class Solution {
    boolean isPossible(int maxBallsInBag, int[] nums, int maxOperations) {
        int totalOperations = 0;
        for (int num : nums) {
            totalOperations += (num - 1) / maxBallsInBag;
            if (totalOperations > maxOperations) {
                return false;
            }
        }
        return true;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = 0;
        for (int num : nums) {
            r = Math.max(r, num);
        }
        int ans = r;
        while (l <= r) {
            int mid = (l + r) / 2; 
            if (isPossible(mid, nums, maxOperations)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
