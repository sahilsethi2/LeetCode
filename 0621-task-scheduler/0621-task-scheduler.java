class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks){
            freq[ch-'A']++;
        }
        Arrays.sort(freq);
        int holes = freq[25]-1;
        int slots = holes*n;
        for(int i = 24; i>=0; i--){
            slots -= Math.min(holes, freq[i]);
        }
        return slots<0 ? tasks.length : tasks.length+slots;
        
    }
}