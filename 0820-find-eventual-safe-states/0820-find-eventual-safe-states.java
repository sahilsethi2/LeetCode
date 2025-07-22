class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int V = graph.length;
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int u = 0; u < V; u++){
            for(int v : graph[u]){
                adj.get(v).add(u);
                indegree[u]++;
            }
        }
        List<Integer> topo = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            topo.add(node);
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        Collections.sort(topo);
        return topo;

    }
}