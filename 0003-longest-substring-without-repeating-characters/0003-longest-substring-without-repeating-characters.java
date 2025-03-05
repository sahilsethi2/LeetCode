class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 ) return 0;
        int l=0, max=0;
        Set<Character> set = new HashSet<>();
        for(int r=0; r<s.length(); r++){
            if(set.contains(s.charAt(r))){
                while(l<r && set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(s.charAt(r));
            max = Math.max(max, r-l+1);
            
        }
        return max;

        // //this is giving TLE!!
        // if(s.length() == 0) return 0;
        // int max = 0;
        // for(int i=0; i<s.length(); i++){
        //     Set<Character> set = new HashSet<>();
        //     for(int j=i; j<s.length();j++){
        //         if(set.contains(s.charAt(j))){
        //             max = Math.max(max, j-i);
        //             break;
        //         }
        //         set.add(s.charAt(j));
        //     }
        // }
        // return max;




        // int maxlen = 0;
        // for(int i=0; i<s.length();i++){
        //     int curlen=0;
        //     boolean[] arr = new boolean[255];
        //     for(int j=i; j<s.length();j++){
        //         if(arr[s.charAt(j)]   ){
        //             break;
        //         }
        //         arr[s.charAt(j)] = true;
        //         curlen++;
        //         maxlen = Math.max(curlen, maxlen);
        //     }
        // }
        // return maxlen;
    }
}