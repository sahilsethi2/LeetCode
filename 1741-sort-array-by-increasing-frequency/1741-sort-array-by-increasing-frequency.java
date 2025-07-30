class Pair{
    int fir;
    int sec;
    public Pair(int fir, int sec){
        this.fir = fir;
        this.sec = sec;
    }
}
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i : nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        ArrayList<Pair> arr = new ArrayList<Pair>();
        for(Map.Entry<Integer,Integer> e:mp.entrySet()){
            arr.add(new Pair(e.getKey(), e.getValue()));
        }
        Collections.sort(arr,(a,b)->{
            if(a.sec==b.sec) return b.fir-a.fir;
            else return a.sec-b.sec;
        });
        List<Integer> res = new ArrayList<>();
        for(Pair p : arr){
            for(int i=0; i<p.sec; i++){
                res.add(p.fir);
            }
        }
        int[] ans = new int[res.size()];
        for(int i=0; i < res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}