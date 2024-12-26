class Solution {
    public void markRow(int[][] arr, int i){
        for(int j=0; j<arr[0].length; j++){
            if(arr[i][j] != 0){
                arr[i][j]=-10;
            }
        }
    }
    public void markCol(int[][] arr, int j){
        for(int i=0; i<arr.length; i++){
            if(arr[i][j] != 0){
                arr[i][j]=-10;
            }
        }
    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    markRow(matrix, i);
                    markCol(matrix, j);
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == -10){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}