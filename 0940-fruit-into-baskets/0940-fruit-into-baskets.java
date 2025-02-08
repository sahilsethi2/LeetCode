class Solution {
    public int totalFruit(int[] fruits) {

        // O(N square) approach below:

        // int maxLen = Integer.MIN_VALUE;
        // for(int i=0; i<fruits.length; i++){
        //     Set<Integer> set = new HashSet<>();
        //     for(int j=i; j<fruits.length; j++){
        //         set.add(fruits[j]);
        //         if(set.size() <= 2){
        //             maxLen = Math.max(maxLen, j-i+1);
        //         }
        //         else{
        //             break;
        //         }
        //     }
        // }
        // return maxLen;


        // Sliding Window Approach:
        int l = 0, r = 0, maxlen = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        while (r < fruits.length) {
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0) + 1); // Fix: Proper value update
            while (mp.size() > 2) { // Remove unnecessary outer if condition
                mp.put(fruits[l], mp.get(fruits[l]) - 1);
                if (mp.get(fruits[l]) == 0) {
                    mp.remove(fruits[l]);
                }
                l++;
            }
            maxlen = Math.max(maxlen, r - l + 1); // Fix: Removed incorrect syntax issue
            r++;
        }
        return maxlen;
    }
}