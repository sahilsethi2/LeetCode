class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            mp.put(arr[i], i);
        }
        
        int minIndex = Integer.MAX_VALUE;

        //check each row one by one
        for(int j = 0; j < mat.length; j++){
            int lastIndex = Integer.MIN_VALUE; //last index in arr when this row will be completely painted!
            for(int k = 0 ; k < mat[j].length; k++){
                int val = mat[j][k];
                int idx = mp.get(val);

                lastIndex = Math.max(lastIndex, idx);
            }
            minIndex = Math.min(minIndex, lastIndex);
        }

        //checking for each column one by one:
        for(int l = 0; l < mat[0].length; l++){
            int lastIndex = Integer.MIN_VALUE; //last index in arr when this row will be completely painted!
            for(int m = 0; m < mat.length; m++){
                int val = mat[m][l];
                int idx = mp.get(val);

                lastIndex = Math.max(lastIndex, idx);
            }
            minIndex = Math.min(minIndex, lastIndex);
        }


        return minIndex;
        
    }
}