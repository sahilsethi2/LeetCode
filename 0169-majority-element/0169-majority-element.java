class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int maj = -1;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
            if(mpp.get(nums[i]) > n/2){
                maj = nums[i];
            }
        }
        return maj;

        // Arrays.sort(nums);
        // int elem = nums[0];
        // int count = 1;
        // for(int i=1; i<nums.length; i++){
        //     if(nums[i]==elem){
        //         count++;
        //     }else{
        //         count--;
        //     }
        //     if(count<0){
        //         elem = nums[i];
        //     }
        // }
        // return elem;

        // int elem = 0;
        // int count = 0;
        // for(int i=0; i<nums.length; i++){
        //     if(count==0){
        //         elem = nums[i];
        //     }
            
        //     if(nums[i]==elem){
        //         count++;
        //     }else{
        //         count--;
        //     }
        // }
        // return elem;
    }
}



















// class Solution {
//     public int max(int[] arr){
//         int max = Integer.MIN_VALUE;
//         for(int i=0; i<arr.length; i++){
//             if(arr[i] > max){
//                 max = arr[i];
//             }
//         }
//         return max;
//     }
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         int count = 0;
//         ArrayList<Integer> arr = new ArrayList<>();
//         for(int i=1; i<nums.length; i++){
//             if(nums[i] == nums[i-1]){
//                 count++;
//                 arr.add(count);
//             }
//         }
//         return max(arr);
//     }
// }