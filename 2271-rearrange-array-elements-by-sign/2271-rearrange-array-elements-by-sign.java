class Solution {
    public int[] rearrangeArray(int[] nums) {
        int ans[] = new int[nums.length];
        int count1 = 0;
        int count2 = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                ans[count1] = nums[i];
                count1 = count1+2;
            }
            else{
                ans[count2] = nums[i];
                count2 = count2+2; 
            }
        }
        return ans;
    }
}