class Solution {
    int result = Integer.MIN_VALUE;
    int m;
    public void solve(int idx, int count, int n, List<Integer> resultant, int[][] requests){
        if(idx>=m){
            boolean allZero = true;

            for(int x : resultant){
                if(x != 0){
                    allZero = false;
                    break;
                }
            }
            if(allZero == true){
                result = Math.max(result, count);
            }
            return;
        }

        int from = requests[idx][0];
        int to = requests[idx][1];

        resultant.set(from, resultant.get(from)-1);
        resultant.set(to, resultant.get(to)+1);

        solve(idx+1, count + 1,  n, resultant, requests);

        resultant.set(from, resultant.get(from)+1);
        resultant.set(to, resultant.get(to)-1);

        solve(idx+1, count, n, resultant, requests);

    }
    public int maximumRequests(int n, int[][] requests) {
        m = requests.length;

        List<Integer> resultant = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            resultant.add(0);
        }

        solve(0,0,n,resultant, requests);

        return result;
    }
}