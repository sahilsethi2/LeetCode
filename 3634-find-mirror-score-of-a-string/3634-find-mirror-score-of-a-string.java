class Solution {
    public long calculateScore(String s) {
        Map<Character, Stack<Integer>> charIndices = new HashMap<>();
        long totalScore = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int dis = c - 'a';
            char mirror = (char) ('z'-dis);

            if(charIndices.containsKey(mirror) && !charIndices.get(mirror).isEmpty()){
                totalScore += (i - charIndices.get(mirror).pop());
            }else{
                charIndices.computeIfAbsent(c,k->new Stack<>()).push(i);
            }
        }
        return totalScore;
    }
}