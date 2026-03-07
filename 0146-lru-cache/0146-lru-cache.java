class Pair{
    int first;
    int second;
    Pair(int f,int s){
        first=f;
        second=s;
    }
}
class LRUCache {
   ArrayList<Pair>al;
   int n;
    public LRUCache(int capacity) {
        al=new ArrayList<>();
        n=capacity;
    }
    
    public int get(int key) {
        for(int i=0;i<al.size();i++){
            if(al.get(i).first==key){
                int val = al.get(i).second;
                Pair p=new Pair(key,val);
                al.remove(i);
                al.add(p);
                // break;
                return val;
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i=0;i<al.size();i++){
            if(al.get(i).first==key){
                al.remove(i);
                al.add(new Pair(key,value));
                return ;
            }
        }
        if(al.size()==n){
            al.remove(0);
            al.add(new Pair(key,value));
        }
        else{
            al.add(new Pair(key,value));
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */