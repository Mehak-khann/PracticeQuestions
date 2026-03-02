class Solution {
    public int lastStoneWeight(int[] stones) {
        int n=stones.length;
        if(n==1) return stones[0];
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            pq.add(stones[i]);
        }
        while(pq.size()>1){
            int y=pq.peek();
            pq.poll();
            int x=pq.peek();
            pq.poll();
            if(x!=y){
                pq.add(y-x);
            }
        }
        if(pq.size()==0) return 0;
        return pq.peek();
    }
}