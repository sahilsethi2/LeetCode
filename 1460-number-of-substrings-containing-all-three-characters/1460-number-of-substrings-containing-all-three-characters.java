class Solution {
    public int numberOfSubstrings(String s) {
        //O(N2) solution: (SC(1)):
        // int count = 0;
        // for(int i=0; i<s.length(); i++){
        //     boolean[] seen = new boolean[3];
        //     for(int j=i; j<s.length(); j++){
        //         seen[s.charAt(j)-'a'] = true;
        //         if(seen[0] && seen[1] && seen[2]){
        //             count = count+(s.length()-j);
        //             break;
        //         }
        //     }
        // }
        // return count;

        int[] lastseen = new int[]{-1,-1,-1};
        int count = 0;
        for(int i=0; i<s.length();i++){
            lastseen[s.charAt(i)-'a'] = i;
            if(lastseen[0] != -1 && lastseen[1] != -1 && lastseen[2] != -1){
                int minn = Math.min(lastseen[0],lastseen[1]);
                count = count + (1+ Math.min(minn,lastseen[2]));
            }
        }
        return count;
    }
}