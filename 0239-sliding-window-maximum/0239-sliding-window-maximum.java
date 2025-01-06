class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];
        int[] ans = new int[n - k + 1];
        int z = 0;
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        st.push(n - 1);
        nge[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) st.pop();
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        for (int i = 0; i <= n - k; i++) {
            int j = i;
            int max = nums[j];
            while (j < i + k) {
                max = Math.max(max, nums[j]);
                if (nge[j] >= i + k) break;
                j = nge[j];
            }
            ans[z++] = max;
        }
        return ans;
    }
}