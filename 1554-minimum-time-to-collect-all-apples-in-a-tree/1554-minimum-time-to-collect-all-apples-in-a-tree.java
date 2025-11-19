class Pair {
    int v;
    boolean a;
    Pair(int v,boolean b){
        this.v = v;
        this.a = b;
    }
}
class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int []edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(new Pair(v,hasApple.get(v)));
            adj.get(v).add(new Pair(u,hasApple.get(u)));
        }
        int res =  dfs(0,adj,-1,hasApple);
        if(res == 0) return 0;
        return res;
    }
    public int dfs(int node,List<List<Pair>> adj,int parent,List<Boolean> hasApple){
        int max = 0;
        for(Pair neigh : adj.get(node)){
            if(neigh.v != parent){
                int d = dfs(neigh.v,adj,node,hasApple);
                if(hasApple.get(neigh.v)) d = d + 2;
                max += d;
            }
        }
        if(max > 0 && node!=0 && !hasApple.get(node)) return max + 2;
        return max;
    }
}