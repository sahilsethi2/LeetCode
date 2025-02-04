class Solution {
    private void recurPermute(int[] arr, List<Integer> ds, List<List<Integer>> ans, boolean[] freq){
        if(ds.size() == arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(arr[i]);
                recurPermute(arr,ds,ans,freq);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        recurPermute(nums, ds, ans, freq);
        return ans;
    }
}