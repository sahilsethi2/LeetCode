class Solution {
    public int[] getConcatenation(int[] nums) {
        int ans[] = new int[2*nums.length];
        int count = 0;
        for(int i=0; i<nums.length; i++){
            ans[count++] = nums[i];
        }
        for(int i=0; i<nums.length; i++){
            ans[count++] = nums[i];
        }
        return ans;
    }
}