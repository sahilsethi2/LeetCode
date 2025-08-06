class Pair {
    int val;
    int i;
    Pair(int val,int i){
        this.val = val;
        this.i = i;
    }
}

class Solution {
    int n;
    Pair [] segTree;
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = baskets.length;
        segTree = new Pair[4*n];
        int count = 0;

        buildTree(baskets,0,0,n-1);
        for(int f : fruits){
            int curr = find(f,0,0,n-1,baskets);
            if(curr==-1) count++;
            else delete(0,0,n-1,curr);
        }
        return count;
    }

    public void buildTree(int [] baskets,int i,int l,int r){
        if(l == r){
            segTree[i] = new Pair(baskets[l],l);
            return;
        }

        int m = l+(r-l)/2;

        buildTree(baskets,2*i+1,l,m);
        buildTree(baskets,2*i+2,m+1,r);

        int v = Math.max(segTree[2*i+1].val,segTree[2*i+2].val);
        segTree[i] = new Pair(v,-1);
    }

    public int find(int f,int i,int l,int r,int [] basket){

        if(segTree[i].val>=f && segTree[i].i!=-1) {
            return segTree[i].i;
        }
        
        if(segTree[i].i!=-1) return -1;

        int m = l+(r-l)/2;
        int L = -1; 
        int R = -1;
        if(segTree[2*i+1].val>=f) L = find(f,2*i+1,l,m,basket);
        if(L!=-1) return L;
        if(segTree[2*i+2].val>=f) R = find(f,2*i+2,m+1,r,basket);
        if(R!=-1) return R;
        return -1;
    }

   public void delete(int i,int l,int r,int idx) {
        if (l == r) {
            segTree[i] = new Pair(Integer.MIN_VALUE,-1);
            return;
        }

        int m = l+(r-l)/2;

        if (idx<=m)delete(2*i+1,l,m,idx);
        else delete(2*i+2,m+1,r,idx);

        int v = Math.max(segTree[2*i+1].val,segTree[2*i+2].val);
        segTree[i] = new Pair(v,-1);
    }
}