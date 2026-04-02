class RecentCounter {
   Queue<Integer>q;
    public RecentCounter() {
        q=new LinkedList<>();
    }
    
    public int ping(int t) {
        int start=t-3000;
        int end=t;
        q.add(t);
         while(q.size()>0){
             if(q.peek()<start){
               q.poll();
             }
             else break;
         }
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */