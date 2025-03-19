class Solution {
    List<Integer> getNSL(int[] arr, int n){
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<n; i++){
            if(st.isEmpty()){
                result.set(i, -1);  
            }
            else{
                while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                    st.pop();
                }
                result.set(i, st.isEmpty() ? -1 : st.peek());
            }
            st.push(i);
        }
        return result;
    }
    List<Integer> getNSR(int[] arr, int n){
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));

        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i>=0; i--){
            if(st.isEmpty()){
                result.set(i, n);  
            }
            else{
                while(!st.isEmpty() && arr[st.peek()] >=  arr[i]){
                    st.pop();
                }
                result.set(i, st.isEmpty() ? n : st.peek());
            }
            st.push(i);
        }
        return result;
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        List<Integer> NSL = getNSL(arr, n);
        List<Integer> NSR = getNSR(arr, n);

        long sum = 0;

        int M = 1000000007;

        for(int i=0; i<n; i++){
            long ls = i - NSL.get(i);
            long rs = NSR.get(i) - i;

            long totalWays = ls*rs;

            long totalSum = (long)arr[i]*totalWays;

            sum  = (sum + totalSum)%M;
        }
        return (int)sum;
    }
}