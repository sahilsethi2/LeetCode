class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int N = n+k-1;
        int[] newarr = new int[N];
        for (int l=0; l<n; l++) {
            newarr[l] = colors[l];
        }
        for (int l=0; l<k-1;l++) {
            newarr[n+l] = colors[l];
        }
        int i=0, j=1, count=0;
        while (j<N) {
            if (newarr[j]==newarr[j-1]){
                i=j;
            }
            if (j-i+1 == k){
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}