class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder();
        int lastId = 0;
        for(int id:spaces){
            res.append(s.substring(lastId,id)).append(" ");
            lastId = id;
        }
        return res.append(s.substring(lastId)).toString();
    }
}