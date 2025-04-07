class Solution {
    static int customBS(int[][] items, int queryPrice){
        int l = 0;
        int r = items.length - 1;
        int max = 0;
        while(l<=r){
            int mid = l + (r-l)/2;

            if(items[mid][0] > queryPrice){
                r = mid - 1;
            }else{
                max = Math.max(max, items[mid][1]);
                l = mid+1;
            }
        }
        return max;
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0;
        int right = items.length - 1;
        int maxBeauty = items[0][1];

        for(int i = 1; i < items.length; i++){
            maxBeauty = Math.max(maxBeauty, items[i][1]);
            items[i][1] = maxBeauty;
        }

        for(int i = 0 ; i < queries.length ; i++){
            int queryPrice = queries[i];
            res[i] = customBS(items, queryPrice);
        }
        return res;
    }
}