class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i : nums){
            mp.put(i, mp.getOrDefault(i,0)+1);
        }
        boolean ans = false;
        for(Map.Entry<Integer,Integer> e : mp.entrySet()){
            if(e.getValue() >= 2){
                ans = true;
            }
        }
        return ans;
    }
}