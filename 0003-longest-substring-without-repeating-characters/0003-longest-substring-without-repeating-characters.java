class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlen = 0;
        for(int i=0; i<s.length();i++){
            int curlen=0;
            boolean[] arr = new boolean[255];
            for(int j=i; j<s.length();j++){
                if(arr[s.charAt(j)]   ){
                    break;
                }
                arr[s.charAt(j)] = true;
                curlen++;
                maxlen = Math.max(curlen, maxlen);
            }
        }
        return maxlen;
    }
}