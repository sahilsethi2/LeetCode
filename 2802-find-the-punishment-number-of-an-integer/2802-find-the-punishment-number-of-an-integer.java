class Solution {
    static boolean check(int i, int currsum, String s, int num){
        if(i == s.length()) {
            return currsum == num;
        }

        if(currsum > num){
            return false;
        }

        boolean possible = false;

        for(int j = i; j < s.length(); j++){
            String sub = s.substring(i, j + 1);
            int val = Integer.parseInt(sub);

            possible = possible || check(j+1, currsum + val, s, num); 

            if(possible == true){
                return true;
            }
        }
        return possible;
    }
    public int punishmentNumber(int n) {
        int punish = 0;
        for(int num = 1 ; num <= n; num++){
            int sq = num * num;
            String s = String.valueOf(sq);
            if(check(0, 0, s, num)){
                punish += sq;
            }
        }
        return punish;
    }
}