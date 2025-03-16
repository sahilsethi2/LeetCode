class Solution {

    boolean isPossible(int[] ranks, long mid, int cars) {
        long carsFixed = 0;

        for (int i = 0; i < ranks.length; i++) {
            carsFixed += (long) Math.sqrt(mid / ranks[i]);
        }
        return carsFixed >= cars;
    }

    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;

        long l = 1;
        int maxR = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            if (ranks[j] > maxR) {
                maxR = ranks[j];
            }
        }

        long r = (long) maxR * cars * cars;

        long result = -1; // Changed from int to long

        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (isPossible(ranks, mid, cars)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}