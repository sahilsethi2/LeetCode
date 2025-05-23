class Solution {
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<>();
        for(String s : logs){
            if(s.equals("../")){
                if(!st.isEmpty()) st.pop();
            }
            else if(!s.equals("./")){
                st.push(s.substring(0, s.length()-1));
            }
        }
        return st.size();
    }
}