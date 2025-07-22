class Solution {
    public int[] findOrder(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[V];
        for(int[] i : edges){
            int u = i[1], v=i[0];
            adj.get(u).add(v);
            indeg[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int[] topo = new int[V];
        int idx = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            topo[idx++] = node;
            for(int it : adj.get(node)){
                indeg[it]--;
                if(indeg[it]==0) q.add(it);
            }
        }
        if(idx == V) return topo;
        return new int[]{};
    }
}