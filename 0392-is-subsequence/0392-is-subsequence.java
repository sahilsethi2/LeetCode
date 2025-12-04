class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = s.length() - 1; 
        int j = t.length() - 1 ;
        return rec(s,t,i,j);
    }
    boolean rec(String s, String t, int i , int j ){
        if(i < 0) return true;
        if(j < 0 ) return false;

        if(s.charAt(i) == t.charAt(j)) return rec(s,t, i-1,j-1);
        return rec(s,t,i,j-1);
    }
}