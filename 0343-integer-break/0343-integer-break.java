class Solution {
    // public int maxProd(int n, int sum, int prod){
    //     if(sum == n) return prod;
    //     if(sum > n) return 0;
    //     int max = 0;
    //     for(int i=1; i<n; i++){
    //         max = Math.max(max, maxProd(n, sum+i, prod*i));
    //     }
    //     return max;
    // }
    public int integerBreak(int n) {
        if(n==2){
            return 1;
        }
        else if(n==3){
            return 2;
        }
        else if(n==4){
            return 4;
        }

        else{
            int pro=1;
            while(n>4){
                pro*=3;  
                n-=3;   
            }
            return(pro*n);
        }
    }
}