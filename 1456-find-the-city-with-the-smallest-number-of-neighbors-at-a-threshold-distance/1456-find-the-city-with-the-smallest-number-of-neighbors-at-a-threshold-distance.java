class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        for(int i=0; i<n;i++){
            for(int j=0;j<n;j++){
                dis[i][j]=(int)1e8;
                if(i==j) dis[i][j]=0;
            }
        }
        for(int[] edge : edges){
            int u=edge[0],v=edge[1], w=edge[2];
            dis[u][v] = w;
            dis[v][u] = w;
        }
        
        for(int via=0; via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dis[i][j]= Math.min(dis[i][j], dis[i][via]+dis[via][j]);
                }
            }
        }
        int mincnt = Integer.MAX_VALUE;
        int city=-1;
        for(int i = 0 ;i < n;i++){
            int cnt=0;
            for(int j=0; j<n ; j++){
                if(i!=j && dis[i][j]<=distanceThreshold)cnt++;
            }
            if(cnt < mincnt || (cnt==mincnt && i>city)){
                mincnt=cnt;
                city = i;
            }
            
        }
        return city;
        
        
    }
}