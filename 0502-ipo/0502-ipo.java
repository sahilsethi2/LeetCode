class Solution {
    class Project implements Comparable<Project>{
        int profit;
        int capital;
        Project(int profit, int capital){
            this.profit = profit;
            this.capital = capital;
        }
        public int compareTo(Project that){
            return this.capital - that.capital; //minHeap
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> minPQ = new PriorityQueue<>();
        //inserting project in minPQ
        int n =  capital.length;
        for(int i=0;i<n; i++){
            minPQ.offer(new Project(profits[i], capital[i]));
        }
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        while(k>0){
            while(!minPQ.isEmpty() && minPQ.peek().capital<=w){
                maxPQ.offer(minPQ.poll().profit);
            }
            if(maxPQ.isEmpty()) break;
            w+=maxPQ.poll();
            k--;
        }
        return w;
    }
}