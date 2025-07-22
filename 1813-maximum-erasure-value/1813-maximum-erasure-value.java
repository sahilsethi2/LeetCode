class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int l=0,r=0;
        Set<Integer> set = new HashSet<>();
        int sum=0, max=0;
        while(r < nums.length){
            while(set.contains(nums[r])){
                set.remove(nums[l]);
                sum-=nums[l];
                l++;
            }
            set.add(nums[r]);
            sum+=nums[r];
            r++;
            max = Math.max(max,sum);
        }
        return max;
    }
}