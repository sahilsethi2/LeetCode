class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Long> freq = new HashMap<>();
        long n=nums.length, totalPairs = n*(n - 1)/2, goodPairs=0;

        for (long i=0;i<n;i++) {
            goodPairs += freq.getOrDefault((int) (i - nums[(int) i]), 0L);
            freq.put((int) (i - nums[(int) i]), freq.getOrDefault((int) (i - nums[(int) i]), 0L) + 1);
        }
        return totalPairs-goodPairs;
    }
}