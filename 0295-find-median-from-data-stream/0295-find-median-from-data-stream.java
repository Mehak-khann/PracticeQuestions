class MedianFinder {
  PriorityQueue<Integer>left;
  PriorityQueue<Integer>right;
    public MedianFinder() {
        left=new PriorityQueue<>(Collections.reverseOrder());
        right=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size()==0 || left.peek()>num){
        left.add(num);
        }
        else{
            right.add(num);
        }
        if(left.size()>right.size()+1){
            right.add(left.poll());
        }
        if(right.size()>left.size()+1){
            left.add(right.poll());
        }

    }
    
    public double findMedian() {
     int totalSize=left.size() + right.size();
     if(totalSize%2!=0){
        if(left.size()>right.size()){
        return (double)left.peek();
        }
        else{
            return (double)right.peek();
        }
     }
     else{
        return (double)(left.peek() + right.peek())/2.0;
     }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */