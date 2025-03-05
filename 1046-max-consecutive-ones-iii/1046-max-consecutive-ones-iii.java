class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0, r=0, maxLen = 0;
        int zeroes=0;
        while(r < nums.length){
            if(nums[r]==0) zeroes++;
            while(zeroes > k){
                if(nums[l]==0){
                    zeroes--;
                }
                l++;
            }
            if(zeroes <= k){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        return maxLen;













        // int i=0,j=0;
        // while(j<nums.length){
        //     if(nums[j]==0){
        //         k--;
        //     }
        //     if(k<0){
        //         if(nums[i]==0) k++;
        //         i++;
        //     }
        //     j++;
        // }
        // return j-i;




        // TLE solution(below):

        // int n= nums.length;
        // int maxLen = 0;
        // for(int i=0; i<n; i++){
        //     int zeros = 0;
        //     for(int j=i; j<n; j++){
        //         if(nums[j]==0) zeros++;
        //         if(zeros<=k){
        //             int len = j-i+1;
        //             maxLen = Math.max(maxLen, len);
        //         }
        //     }
        // }
        // return maxLen;


        //Sliding Window solution below;
        // int maxLen = 0,l=0,r=0,zeros=0;
        // while(r<nums.length){
        //     if(nums[r]==0) zeros++;
        //     while(zeros>k){
        //         if(nums[l] == 0) zeros--; 
        //         l++;
        //     }
        //     if(zeros<=k){
        //         int len = r-l+1;
        //         maxLen = Math.max(maxLen, len);
        //     }
        //     r++;
        // }
        // return maxLen;

    }
}