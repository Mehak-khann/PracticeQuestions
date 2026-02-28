class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n=deck.length;
        int[] res=new int[n];
        Queue<Integer>q=new LinkedList<>();
        Arrays.sort(deck);
        
       // List<Integer>list=new LinkedList<>(q);
       // Collections.sort(list);
      //  q.clear();
      //  q.addAll(list);
    for(int i=0;i<n;i++){
        q.add(i);
    }
        int i=0;
        while(!q.isEmpty()){
            res[q.peek()]=deck[i];
            q.poll();
            q.add(q.peek());
            q.poll();
            i++;
        }
        return res;
    }
}