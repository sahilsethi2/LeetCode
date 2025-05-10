class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int zeros1 = 0; int zeros2 = 0;
        long sum1 = 0 ; long sum2 = 0 ;
        for(int i = 0; i < nums1.length; i++){
            if(nums1[i] == 0)zeros1++ ;
            sum1 += nums1[i];
        }
        for(int i = 0;  i < nums2.length; i++){
            if(nums2[i] == 0)zeros2++;
            sum2 += nums2[i];
        }
        if (zeros1 > 0 && zeros2 > 0){
            return Math.max(sum1 + zeros1, sum2 + zeros2);
        }
        if (zeros1 > 0){
            if(sum1 + zeros1 <= sum2) return sum2;
            else return -1;
        }
        if (zeros2 > 0){
            if(sum2 + zeros2 <= sum1) return sum1;
            else return -1;
        }
        return sum1==sum2 ? sum1 : -1;
    }
}