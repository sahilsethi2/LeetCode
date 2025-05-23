class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<n; j++){
                if(j!=i+1 && nums[j] == nums[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k<l){
                    long sum =(long) nums[i] + nums[j];
                    sum += (long)nums[k];
                    sum += (long)nums[l];
                    if(sum == target){
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        ans.add(temp);
                        k++; l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }
                    else if(sum<target) k++;
                    else l--;
                }
            }
        }
        return ans;






        // int n = nums.length;
        // Set<List<Integer>> list = new HashSet<>();
        // Arrays.sort(nums);
        // for(int i=0; i<n; i++){
        //     for(int j=i+1; j<n; j++){
        //         Set<Integer> set = new HashSet<>();
        //         for(int k=j+1;k<n; k++){
        //             int sum = nums[i];
        //             sum += nums[j];
        //             sum += nums[k];
        //             int fourth = target - sum;
        //             if(set.contains(fourth)){
        //                 List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], fourth);
        //                 // Collections.sort(temp);
        //                 list.add(temp);
        //             }
        //             set.add(nums[k]);
        //         }
        //     }
        // }
        // List<List<Integer>> ans = new ArrayList<>(list);
        // return ans;




        // int n = nums.length;
        // Set<List<Integer>> set = new HashSet<>();
        // for(int i=0; i<n; i++){
        //     for(int j=i+1; j<n; j++){
        //         for(int k=j+1; k<n; k++){
        //             for(int l=k+1; l<n; l++){
        //                 int sum = nums[i] + nums[j];
        //                 sum += nums[k];
        //                 sum += nums[l];

        //                 if(sum == target){
        //                     List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
        //                     Collections.sort(temp);
        //                     set.add(temp);
        //                 }
        //             }
        //         }
        //     }
        // }
        // List<List<Integer>> ans = new ArrayList<>(set);
        // return ans;
    }
}