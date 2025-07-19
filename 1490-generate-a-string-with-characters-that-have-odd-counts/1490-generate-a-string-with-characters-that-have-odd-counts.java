class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n;i++){
            sb.append('a');
        }
        if(sb.length()%2==0 && sb.length()>=1){
            sb.setCharAt(0,'b');
        }
        return sb.toString();
    }
}