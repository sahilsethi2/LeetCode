class Solution {
    public String reverse(String str){
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            String rev = reverse(arr[i]);
            ans.append(rev).append(" ");
        }
        return ans.toString().trim();
    }
}