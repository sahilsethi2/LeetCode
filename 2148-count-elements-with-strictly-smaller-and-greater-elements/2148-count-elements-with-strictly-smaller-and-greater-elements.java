class Solution {
    public int countElements(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for(int i:nums){
            mini = Math.min(mini,i);
            maxi = Math.max(maxi,i);
        }
        int ans = 0;
        for(int num : nums){
            if(num>mini && num<maxi) ans++;
        }
        return ans;
    }
}