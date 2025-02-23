class Solution {
    public double minimumAverage(int[] nums) {
        int i=0, j = nums.length-1;
        Arrays.sort(nums);
        List<Double> averages = new ArrayList<>();
        while(i<j){
            int minElem = nums[i];
            int maxElem = nums[j];
            averages.add((minElem + maxElem)/2.0);
            i++;
            j--;
        }

        double minn = Integer.MAX_VALUE;
        for(int k=0;k<averages.size(); k++){
            if(averages.get(k) < minn){
                minn = Math.min(minn, averages.get(k));
            }
        }
        return minn;
    }
}