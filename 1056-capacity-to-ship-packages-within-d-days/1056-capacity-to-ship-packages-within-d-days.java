class Solution {
    public int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max) max=arr[i];
        }
        return max;
    }
    public int findDays(int[] weights, int cap){
        int days = 1,load=0;
        for(int i=0; i<weights.length; i++){
            if(weights[i]+load > cap){
                days += 1;
                load = weights[i];
            }
            else{
                load += weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int l = max(weights);
        int sum = 0;
        for(int i=0; i<weights.length;i++){
            sum+=weights[i];
        }
        int h = sum;
        while(l<=h){
            int mid = (l+h)/2;
            int no = findDays(weights, mid);
            if(no<=days){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}