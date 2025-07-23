class Solution {
    String removeSubstr(String s, String matchStr){
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && st.peek() == matchStr.charAt(0) && ch == matchStr.charAt(1)){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        StringBuilder temp = new StringBuilder();

        while(!st.isEmpty()){
            temp.append(st.peek());
            st.pop();
        }

        return temp.reverse().toString();
    }
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        int score = 0;
        String max = (x >= y) ? "ab" : "ba";
        String min = (x < y) ? "ab" : "ba";

        // First pass:
        String temp = removeSubstr(s, max);
        int L = temp.length();

        int charRemoved = (n-L);

        score += (charRemoved/2) * Math.max(x, y);

        // Second pass:
        String temp2 = removeSubstr(temp, min);
        charRemoved = L - temp2.length();

        score += (charRemoved/2) * Math.min(x,y);

        return score;
    }
}