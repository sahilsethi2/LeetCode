class Solution {
    private boolean check(int st, int V,int[][] graph, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        color[st]=0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            for(int it : graph[node]){
                if(color[it]==-1){
                    color[it] = (color[node]==1) ? 0 : 1;
                    q.add(it);
                }else if(color[it]==color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i =0; i<color.length; i++) color[i]=-1;

        for(int i = 0; i <graph.length; i++){
            if(color[i]==-1){
                if(check(i,graph.length,graph,color)==false){
                    return false;
                }
            }
        }
        return true;
    }
}