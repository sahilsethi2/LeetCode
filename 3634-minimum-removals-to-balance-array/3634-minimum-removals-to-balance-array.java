class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n<=1) return 0;
        int maxi = 0;
        int i = 0;
        for(int j =0; j < n; j++){
            while(nums[j] > (long) nums[i]*k){
                i++;
            }
            maxi = Math.max(maxi, j-i+1);
        }
        return n - maxi;
    }
}
