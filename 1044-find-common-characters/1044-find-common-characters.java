class Solution {
    public List<String> commonChars(String[] words) {
        List<Integer> finalFreq = new ArrayList<>(Collections.nCopies(26, Integer.MAX_VALUE));

        for (String word : words) {
            List<Integer> curFreq = new ArrayList<>(Collections.nCopies(26, 0));
            for (char c : word.toCharArray()) {
                curFreq.set(c - 'a', curFreq.get(c - 'a') + 1);
            }
            for (int i = 0; i < 26; i++) {
                finalFreq.set(i, Math.min(finalFreq.get(i), curFreq.get(i)));
            }
        }
        List<String> ans = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            while (finalFreq.get(c - 'a') > 0) {
                ans.add(String.valueOf(c));
                finalFreq.set(c - 'a', finalFreq.get(c - 'a') - 1);
            }
        }
        return ans;
    }
}