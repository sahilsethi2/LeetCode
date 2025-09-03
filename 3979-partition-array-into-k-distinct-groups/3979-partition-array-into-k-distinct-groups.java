class Solution {
    public boolean partitionArray(int[] nums, int k) {
        Map<Integer , Integer>mpp= new HashMap<>() ; 

        int n= nums.length ; 

        if(n%k!=0)return false ; 

        for(int it : nums)
        {
            mpp.put(it , mpp.getOrDefault(it , 0)+1) ; 
        }

        for(int i : mpp.keySet())
        {
            int freq= mpp.get(i) ; 

            if(freq>(n/k) )return false ; 
        }

        return true ; 
    }
}