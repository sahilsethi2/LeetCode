class Solution {
    public boolean isPossible(long mid, int[] stations, int r, int k) {
        int n = stations.length;
        long[] copy = new long[n]; // work on a copy to avoid mutation
        for (int i = 0; i < n; i++) {
            copy[i] = stations[i];
        }

        long sum = 0;
        // initial window sum for city 0
        for (int i = 0; i <= r && i < n; i++) {
            sum += copy[i];
        }

        for (int i = 0; i < n; i++) {
            if (sum < mid) {
                long need = mid - sum;
                if (need > k) return false; // not enough k to fill deficit
                k -= need;
                if (i + r < n) {
                    copy[i + r] += need; // place extra power at farthest reachable right index
                }
                sum += need;
            }

            // Slide window to the right
            if (i + r + 1 < n) sum += copy[i + r + 1];
            if (i - r >= 0) sum -= copy[i - r];
        }
        return true;
    }

    public long maxPower(int[] stations, int r, int k) {
        long low = 0;
        long high = k;
        int n = stations.length;

        for (int x : stations) high += x; // upper bound of possible power

        long ans = 0;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(mid, stations, r, k)) {
                ans = mid;
                low = mid + 1; // try bigger minimum
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
