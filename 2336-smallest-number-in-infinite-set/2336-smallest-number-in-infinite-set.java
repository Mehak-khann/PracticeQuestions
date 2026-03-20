class SmallestInfiniteSet {
  int[] arr;
    PriorityQueue<Integer>pq;
    public SmallestInfiniteSet() {
        arr=new int[1001];
        pq=new PriorityQueue<>();
        for(int i=1;i<1001;i++){
            arr[i]=i;
            pq.add(i);
        }
        
    }
    
    public int popSmallest() {
        if(pq.size()>0){
        arr[pq.peek()]=0;
       if(pq.size()>0){
           return pq.poll();
       }
        }
        return -1;
    }
    
    public void addBack(int num) {
        if(arr[num]==0){
            arr[num]=num;
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */