class Solution {
    public int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length;i++){
            if(arr[i] > max) max = arr[i];
        }
        return max;
    }
    public int min(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<arr.length;i++){
            if(arr[i] < min) min = arr[i];
        }
        return min;
    }
    public boolean isPos(int[] arr, int days, int m, int k){
        int count=0, pos=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= days){
                count++;
            }else{
                pos += count/k;
                count=0;
            }
        }
        pos += count/k;
        return pos >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < m*k) return -1;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isPos(bloomDay, mid, m, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return isPos(bloomDay, left, m, k) ? left : -1;
    }
}



//BRUTE FORCE APPROACH (Gives TLE):
// class Solution {
//     public int max(int[] arr){
//         int max = Integer.MIN_VALUE;
//         for(int i=0; i<arr.length;i++){
//             if(arr[i] > max) max = arr[i];
//         }
//         return max;
//     }
//     public int min(int[] arr){
//         int min = Integer.MAX_VALUE;
//         for(int i=0; i<arr.length;i++){
//             if(arr[i] < min) min = arr[i];
//         }
//         return min;
//     }
//     public boolean isPos(int[] arr, int days, int m, int k){
//         int count=0, pos=0;
//         for(int i=0; i<arr.length; i++){
//             if(arr[i] <= days){
//                 count++;
//             }else{
//                 pos += count/k;
//                 count=0;
//             }
//         }
//         pos += count/k;
//         return pos >= m;
//     }
//     public int minDays(int[] bloomDay, int m, int k) {
//         if(bloomDay.length < m*k) return -1;
//         for(int i=min(bloomDay); i<=max(bloomDay); i++){
//             if(isPos(bloomDay,i,m,k)==true){
//                 return i;
//             }
//         }
//         return -1;
//     }
// }