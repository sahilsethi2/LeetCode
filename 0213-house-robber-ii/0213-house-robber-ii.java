class Solution {
    int func(List<Integer> arr) {
        int n = arr.size();
        int prev = arr.get(0);
        int prev2 = 0;
        
        for (int i = 1; i < n; i++) {
            int take = arr.get(i);
            if (i > 1) take += prev2;

            int nottake = prev;

            int curr = Math.max(take, nottake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public int rob(int[] nums) {
        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();

        if (nums.length == 1) return nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) temp1.add(nums[i]);
            if (i != nums.length - 1) temp2.add(nums[i]);
        }

        return Math.max(func(temp1), func(temp2));
    }
}