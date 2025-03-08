class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int cur = nums[i];
            int more = target - cur;
            if(mpp.containsKey(more)) return new int[]{mpp.get(more), i};
            mpp.put(cur, i);
        }
        return new int[]{0,0};



        // for (int i = 0; i<nums.length; i++){  
        //     for (int j = i+1; j<nums.length; j++){  
        //         if (nums[j] == target - nums[i]){
        //             return new int[] {i, j};
        //         }
        //     }            
        // }
        // return new int[] {0, 0};    


        // another approach in O(NlogN):
        
        // Arrays.sort(nums);
        // int i=0;
        // int j = nums.length - 1;
        // if(nums[i]+nums[j] == target) return new int[] {i,j};
        // else if(nums[i]+nums[j]<target) i++;
        // else if(nums[i]+nums[j]>target) j--;
    }
    // return new int[] {0,0};
}