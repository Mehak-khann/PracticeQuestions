class Solution {
    class Pair{
        String second;
        int first;
        Pair(int f,String s){
            first=f;
            second=s;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String>l=new LinkedList<>();
       int n=words.length;
        HashMap<String,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(words[i],mp.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<Pair>pq=new PriorityQueue<>(
           // (a,b)->a.first==b.first?a.second.compareTo(b.second):a.first-b.first
         (a, b) -> a.first == b.first ? b.second.compareTo(a.second) : a.first - b.first   
        );
        for(Map.Entry<String,Integer>entry:mp.entrySet()){
            int freq=entry.getValue();
            String key=entry.getKey();
            Pair p=new Pair(freq,key);
            pq.add(p);

            if(pq.size()>k){
                pq.poll();
            }
            
        }
        while(!pq.isEmpty()){
            l.add(pq.peek().second);
            pq.poll();
        }
       Collections.reverse(l);
        return l;
    }
}