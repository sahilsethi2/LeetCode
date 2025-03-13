class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int negCount = 0;
        int minSmallest = Integer.MAX_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                sum += Math.abs(matrix[i][j]);
                minSmallest = Math.min(minSmallest, Math.abs(matrix[i][j]));
                if(matrix[i][j] < 0) negCount++;
            }
        }

        if(negCount%2 == 1){
            sum -= 2*minSmallest;
        }
        return sum;
    }
}