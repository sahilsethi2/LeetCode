class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int num : arr1) {
            int left = 0, right = arr2.length - 1;
            boolean isValid = true;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (Math.abs(num - arr2[mid]) <= d) {
                    isValid = false;
                    break;
                } 
                if (arr2[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (isValid) {
                count++;
            }
        }
        return count;  
    }
}