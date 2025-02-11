class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        for(int i=0; i<n; i++){
            Set<Integer> hashset = new HashSet<>();
            for(int j=i+1; j<n; j++){
                int third = -(nums[i]+nums[j]);

                // Arrays.sort(nums);

                if(hashset.contains(third)){
                    List<Integer> list = Arrays.asList(nums[i],nums[j],third);
                    Collections.sort(list);
                    set.add(list);
                }
                hashset.add(nums[j]);
                
            }
            
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }  
        



    //     Set<List<Integer>> set = new HashSet<>();

    //     for(int i=0; i<nums.length; i++){
    //         for(int j=i+1; j<nums.length; j++){
    //             for(int k=j+1; k<nums.length; k++){
    //                 if(nums[i]+nums[j]+nums[k]==0){
    //                     int[] temp = new int[]{nums[i], nums[j],nums[k]};
    //                     Arrays.sort(temp);
    //                     set.add(temp);
    //                 }
    //             }
    //         }
    //     }
    //     List<List<Integer>> ans = new ArrayList<>();
    // }
    // return ans;
}