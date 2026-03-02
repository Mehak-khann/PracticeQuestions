class Solution {
    class Pair{
        int first;
        int second;
        Pair(int f ,int s){
            first=f;
            second=s;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>(
            (a,b)->a.first==b.first?a.second - b.second : a.first-b.first
        );
        //Iterate map
        for(Map.Entry<Integer, Integer>entry:mp.entrySet()){
            int freq=entry.getValue();
            int key=entry.getKey();
            pq.add(new Pair(freq,key));

            if(pq.size()>k){
                pq.poll();
            }
        }
      int[] res=new int[pq.size()];
        int idx=0;
        while(!pq.isEmpty()){
            res[idx]=pq.peek().second;
            idx++;
            pq.poll();
        }
        
        return res;
    }
}