class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxi = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i : nums){
            mp.put(i, mp.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> e :mp.entrySet()){
            maxi = Math.max(maxi, e.getValue());
        }
        int cnt = 0;
        for(int i : nums){
            if(mp.get(i) == maxi) cnt++;
        }
        return cnt;
        
    }
}