class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        int temp = original;
        for(int i=0 ; i<nums.length; i++){
            if(nums[i]==temp){
                original*=2;
                temp = original;
            }
        }
        return temp;
    }
}