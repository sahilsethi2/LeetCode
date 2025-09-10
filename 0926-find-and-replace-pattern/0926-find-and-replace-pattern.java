class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result=new ArrayList<>();
        for(String str:words){
            Map<Character,Character> map=new HashMap<>();
            boolean flag=true;
            for(int i=0; i<pattern.length(); i++){
                if(map.containsKey(pattern.charAt(i))){
                    if(!(str.charAt(i) == map.get(pattern.charAt(i)))){
                        flag=false;
                        break;
                    }
                }
                else{
                    if(map.containsValue(str.charAt(i))){
                        flag=false;
                        break;
                    }
                    map.put(pattern.charAt(i),str.charAt(i));
                }
            }
            if(flag) result.add(str);
        }
        return result;
    }
}