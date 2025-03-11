class Solution {
    int result = Integer.MAX_VALUE;
    int n;
    void solve(int idx, int[] cookies, List<Integer> children, int k){
        if(idx>=n){
            
                int unfairness = Collections.max(children);
                result = Math.min(result, unfairness);
            
            return;
        }
        int cookie = cookies[idx];
        for(int i = 0; i<k; i++){
            if (children.get(i) + cookie >= result) continue;


            children.set(i, children.get(i) + cookie);
            solve(idx + 1, cookies, children, k);
            children.set(i, children.get(i) - cookie);
        }
    }
    public int distributeCookies(int[] cookies, int k) {
        n = cookies.length;
        List<Integer> children = new ArrayList<>();
        for (int i = 0; i < k; i++){
            children.add(0);
        }

        solve(0, cookies, children, k);

        return result;
    }
}