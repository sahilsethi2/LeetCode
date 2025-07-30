class Solution {
    public int singleNumber(int[] nums) {
        // int cnt = 1;
        // Arrays.sort(nums);
        // int el = -1;
        // int mini = Integer.MAX_VALUE;
        // for(int i=0; i<nums.length; i++){
        //     if(nums[i]==nums[i-1]) cnt++;
        //     else cnt=0;
        //     mini = Math.min(mini,cnt);
        //     if(cnt==mini) el = nums[i];
        // }
        // return el;
        Map<Integer,Integer>mp = new HashMap<>();
        for(int i : nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer>e:mp.entrySet()){
            if(e.getValue()==1) return e.getKey();
        }
        return -1;
    }
}