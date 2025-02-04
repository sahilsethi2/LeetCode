class Solution {
    private void findSubsets(int index, int[] arr, List<Integer> ds, List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i=index; i<arr.length; i++){
            if(i!=index && arr[i]==arr[i-1]) continue;
            ds.add(arr[i]);
            findSubsets(i+1, arr,ds, ans);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0,nums,new ArrayList<>(), ansList);
        return ansList;
    }
}