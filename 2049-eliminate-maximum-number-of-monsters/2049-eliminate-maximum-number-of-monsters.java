class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n=dist.length;
        int[] time = new int[n];
        for(int i = 0; i <n; i++){
            time[i] = (int)Math.ceil((double)dist[i]/speed[i]);
        }
        Arrays.sort(time);
        int tm=1;
        int cnt = 1;
        for(int i = 1 ; i < n ; i++ ){
            if(time[i]-tm <=0 ) return cnt;
            cnt++;
            tm++;
        }
        return cnt;
    }
}