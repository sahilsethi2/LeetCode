class Solution {
    public boolean canFinish(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[V];
        for(int[] i : edges){
            int u = i[0], v=i[1];
            adj.get(u).add(v);
            indeg[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            topo.add(node);
            for(int it : adj.get(node)){
                indeg[it]--;
                if(indeg[it]==0) q.add(it);
            }
        }
        if(topo.size() == V) return true;
        return false;
    }
}