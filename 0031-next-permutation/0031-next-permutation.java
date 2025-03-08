class Solution {
    public void reverse(int[] arr, int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int golaIndex = -1;
        for(int i=n-1; i>0; i--){
            if(nums[i] > nums[i-1]){
                golaIndex = i-1;
                break;
            }
        }
        if(golaIndex != -1){
            int swapIndex = golaIndex;
            for(int j = n-1; j>=golaIndex+1; j--){
                if(nums[j]>nums[golaIndex]){
                swapIndex = j;
                break;
                }
            }
            swap(nums, golaIndex, swapIndex);  
        }
        reverse(nums, golaIndex+1, n-1);
        
    }
}