class Solution {
    List<String> result = new ArrayList<>();
    String temp;
    public void solve(int idx, String digits, String temp, Map<Character, String> mpp){
        if(idx >= digits.length()){
            result.add(temp);
            return;
        }
        char ch = digits.charAt(idx);
        String str = mpp.get(ch);

        for(int i=0; i<str.length(); i++){
            temp += str.charAt(i);
            solve(idx+1, digits, temp, mpp);
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return new ArrayList<>();
        }
        Map<Character, String> mpp = new HashMap<>();
        mpp.put('2', "abc");
        mpp.put('3', "def");
        mpp.put('4', "ghi");
        mpp.put('5', "jkl");
        mpp.put('6', "mno");
        mpp.put('7', "pqrs");
        mpp.put('8', "tuv");
        mpp.put('9', "wxyz");

        

        solve(0, digits, "", mpp);

        return result;
    }
}