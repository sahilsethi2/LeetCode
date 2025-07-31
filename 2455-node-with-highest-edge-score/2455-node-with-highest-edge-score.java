class Solution {
    public int edgeScore(int[] edges) {
        long maxi = -1;
        long[] sumofin = new long[edges.length];
        for(int i = 0; i < edges.length; i++){
            sumofin[edges[i]] += i;
        }
        int el = -1;
        for(int i = 0 ;i < sumofin.length; i++){
            if(sumofin[i]>maxi) {
                maxi = sumofin[i];
                el = i;
            }
        }
        return el;
    }
}