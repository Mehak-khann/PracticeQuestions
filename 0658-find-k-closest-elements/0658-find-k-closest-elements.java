class Pair{
    int first;
    int second;
    Pair(int f, int s){
        first=f;
        second=s;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n =arr.length;
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            if(b.first==a.first){
                return b.second-a.second;
            }
            return b.first-a.first;
    });
        for(int i=0;i<n;i++){
            int second=Math.abs(x-arr[i]);
            Pair p = new Pair(second,arr[i]);
            pq.add(p);
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<Integer>l=new ArrayList<>();
        while(pq.size()>0){
            l.add(pq.peek().second);
            pq.poll();
        }
        Collections.sort(l);
return l;
    }
}