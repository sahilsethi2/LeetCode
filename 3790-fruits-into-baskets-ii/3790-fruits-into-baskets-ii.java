class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int cnt = 0;
        boolean[] used = new boolean[baskets.length];
        for(int i = 0 ; i < fruits.length ;i++){
            boolean put = false;
            for(int j = 0 ; j < baskets.length; j++){
                if(baskets[j]>=fruits[i] && used[j]==false){
                    put=true;
                    used[j] = true;
                    break;
                }
            }
            if(put==false) cnt++;
        }
        return cnt;
    }
}