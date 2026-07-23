// class NumberContainers {
//     HashMap<Integer,Integer>mpIdx;
//     HashMap<Integer,PriorityQueue<Integer>>mp2;
//     public NumberContainers() {
//         mpIdx=new HashMap<>();
//         mp2=new HashMap<>();
//     }
    
//     public void change(int index, int number) {
//         mpIdx.put(index,number);
//         PriorityQueue pq = mp2.get(number);
//         if(pq==null){
//             pq=new LinkedList<>();
//         pq.add(index);
//         mp2.put(number,pq);
//         }
//         else{
//             pq.add(index);

//         }

//     }
    
//     public int find(int number) {
//         if(!mpIdx.containsKey(number)){
//             return -1;
//         }
//         PriorityQueue pq  = new PriorityQueue<>();
//         while(pq.size()>0){
//             if(mpIdx.containsKey(pq.peek())){
//                 return pq.peek();
//             }
//              pq.poll();
//         }
//         return -1;
//     }
// }

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */

 class NumberContainers {
    HashMap<Integer, Integer> mpIdx;
    HashMap<Integer, PriorityQueue<Integer>> mp2;

    public NumberContainers() {
        mpIdx = new HashMap<>();
        mp2 = new HashMap<>();
    }
    
    public void change(int index, int number) {
        mpIdx.put(index, number);
        
        PriorityQueue<Integer> pq = mp2.get(number);
        if (pq == null) {
            pq = new PriorityQueue<>();
            pq.add(index);
            mp2.put(number, pq);
        } else {
            pq.add(index);
        }
    }
    
    public int find(int number) {
        // Check if the number exists in mp2
        if (!mp2.containsKey(number)) {
            return -1;
        }
        
        // Retrieve the priority queue associated with this number
        PriorityQueue<Integer> pq = mp2.get(number);
        
        while (pq.size() > 0) {
            int smallestIndex = pq.peek();
            // Verify if this index still points to the requested number
            if (mpIdx.get(smallestIndex) == number) {
                return smallestIndex;
            }
            pq.poll();
        }
        
        return -1;
    }
}