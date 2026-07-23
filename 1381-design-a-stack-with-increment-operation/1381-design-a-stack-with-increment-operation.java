class CustomStack {
    List<Integer>list;
    int m;
    public CustomStack(int maxSize) {
        m  =maxSize;
        list =new ArrayList<>();
    }
    
    public void push(int x) {
        if(list.size()<m){
        list.add(x);
        }
    }
    
    public int pop() {
       if(list.size()!=0){
        int val =list.get(list.size()-1);
        list.remove(list.size()-1);
        return val;
       }
       return -1;
    }
    
    public void increment(int k, int val) {
      if(k>list.size()){
        for(int i=0;i<list.size();i++){
            list.set(i,list.get(i)+val);
        }
      }
      else{
      for(int i=0;i<k;i++){
        list.set(i,list.get(i)+val);
      }
      }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */