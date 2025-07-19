class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        for(char ch: s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        return new HashSet<>(mp.values()).size() == 1;
    }
}