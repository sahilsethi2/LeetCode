class Solution {
    public boolean check(String a, String b){
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for(char ch : a.toCharArray()) set1.add(ch);
        for(char ch : b.toCharArray()) set2.add(ch);
        
        int[] arr1 = new int[set1.size()];
        int i =0 ;
        for(char ch: set1){
            arr1[i++] = ch;
        }
        int[] arr2 = new int[set2.size()];
        int j=0 ;
        for(char ch: set2){
            arr2[j++] = ch;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
        
    }
    public int similarPairs(String[] words) {
        int cnt = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i+1; j<words.length; j++){
                if(check(words[i],words[j])) cnt++;
            }
        }
        return cnt;
    }
}