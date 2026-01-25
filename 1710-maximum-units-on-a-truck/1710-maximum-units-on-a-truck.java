class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<Integer> li = new ArrayList<>();
        for(int i=0; i<boxTypes.length; i++){
            for(int j=0; j<boxTypes[i][0]; j++){
                li.add(boxTypes[i][1]);
            }
        }
        li.sort(Collections.reverseOrder());
        int sum = 0;
        for(int i=0; i<li.size() && i<truckSize; i++){
            sum += li.get(i);
        }
        return sum;
    }
}