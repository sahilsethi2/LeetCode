class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        Map<Integer, Integer> top = new HashMap<>();
        Map<Integer, Integer> bot = new HashMap<>();
        Map<Integer, Integer> same = new HashMap<>();

        for (int i = 0; i < n; i++){
            top.put(tops[i], top.getOrDefault(tops[i], 0) + 1);
            bot.put(bottoms[i], bot.getOrDefault(bottoms[i], 0) + 1);
            if(tops[i] == bottoms[i]) {
                same.put(tops[i], same.getOrDefault(tops[i], 0) + 1);
            }
        }

        for(int no = 1; no <= 6; no++){
            int t = top.getOrDefault(no, 0);
            int b = bot.getOrDefault(no, 0);
            int s = same.getOrDefault(no, 0);
            if (t+b-s >= n) {
                return n - Math.max(t,b);
            }
        }

        return -1;
    }
}