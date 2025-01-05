class Solution {
    boolean isPossible(int maxBallsInBag, int[] nums, int maxOperations) {
        int totalOperations = 0;
        for (int num : nums) {
            // Har bag ko todne ke liye kitne operations lagenge
            totalOperations += (num - 1) / maxBallsInBag;
            if (totalOperations > maxOperations) {
                return false; // Agar allowed operations se zyada ho gaye toh yeh possible nahi hai
            }
        }
        return true;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1, r = 0;
        for (int num : nums) {
            r = Math.max(r, num); // Maximum balls ke liye range set karo
        }

        int ans = r; // Sabse bada penalty initially
        while (l <= r) {
            int mid = (l + r) / 2; // Mid-point (possible penalty)
            if (isPossible(mid, nums, maxOperations)) {
                ans = mid; // Agar possible hai, toh penalty aur kam karne ki koshish karo
                r = mid - 1;
            } else {
                l = mid + 1; // Agar possible nahi hai, toh penalty badhao
            }
        }
        return ans;
    }
}