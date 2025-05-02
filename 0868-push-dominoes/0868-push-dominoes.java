class Solution {
    public static void solve(char[] arr, int i , int j){
        if(arr[i] == 'L' && arr[j] == 'L'){
            for(int s = i+1; s <= j-1; s++){
                arr[s] = 'L';
            }
        }
        else if(arr[i] == 'R' && arr[j] == 'R'){
            for(int s = i+1; s <= j-1; s++){
                arr[s] = 'R';
            }
        }else if(arr[i] == 'L' && arr[j] == 'R'){
            // do nothing
        }else{
            int mid = (i+j)/2;
            if((j - i)%2 == 0){
                for(int s = i+1; s < mid; s++){
                    arr[s] = 'R';
                }
                for(int s = mid+1; s < j; s++){
                    arr[s] = 'L';
                }
            }else{
                for(int s = i; s <= mid; s++){
                    arr[s] = 'R';
                }
                for(int s = mid+1; s < j; s++){
                    arr[s] = 'L';
                }
            }
        }
    }
    public String pushDominoes(String s) {
        int n = s.length();
        char[] arr = new char[n+2];
        arr[0] = 'L';
        arr[n+1] = 'R';
        for(int i = 1; i <= n; i++){
            arr[i] = s.charAt(i-1);
        }

        int j = 0;
        int k = 1;
        while(k < arr.length){
            while(arr[k] == '.'){
                k++;
            }
            if(k-j > 1){
                solve(arr, j, k);
            }
            j = k;  k++;
        }

        String res = "";
        for(int i = 1; i < arr.length - 1; i++){
            res += arr[i];
        }
        return res;
    }
}