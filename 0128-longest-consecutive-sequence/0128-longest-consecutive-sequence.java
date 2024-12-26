class Solution {
    public int longestConsecutive(int[] nums){
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longest = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak++;
                } else {
                    longest = Math.max(longest, currentStreak);
                    currentStreak = 1;
                }
            }
        }
        
        return Math.max(longest, currentStreak);
    }
}










// class Solution {
//     public boolean linearSearch(int[] arr, int num){
//         for(int i=0; i<arr.length; i++){
//             if(arr[i]==num){
//                 return true;
//             }
//         }
//         return false;
//     }
//     public int longestConsecutive(int[] nums) {
//         int count=0;
//         for(int i=0; i<nums.length; i++){
//             int x = nums[i];
//             int currcount = 1;
//             while(linearSearch(nums, x+1) == true){
//                 currcount++;
//                 x=x+1;
//             }
//             count = Math.max(currcount, count);

//         }
//         return count;
//     }
// }






// class Solution {
//     public int longestConsecutive(int[] nums) {
//         HashSet<Integer> st = new HashSet<>();
//         for(int num:nums) st.add(num);
//         int maxStreak = 0;
//         for(int num:st){
//             if(!st.contains(num-1)){
//                 int currNum = num;
//                 int currStreak=1;
//                 while(st.contains(currNum+1)){
//                     currStreak++;
//                     currNum++;
//                 }
//                 maxStreak = Math.max(maxStreak, currStreak);
//             }
//         }
//         return maxStreak;
//     }
// }