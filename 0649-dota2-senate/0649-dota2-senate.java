class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer>q=new LinkedList<>();
        Queue<Integer>r=new LinkedList<>();
        Queue<Integer>d=new LinkedList<>();
        for(int i=0;i<senate.length();i++){
            q.add(i);
            if(senate.charAt(i)=='R') r.add(i);
            else d.add(i);
        }
        StringBuilder sb=new StringBuilder(senate);
            while(q.size()>1){
            if(sb.charAt(q.peek())=='X') q.poll();
            else if(sb.charAt(q.peek())=='R'){
                if(d.size()==0) return "Radiant";
                else{
                    sb.setCharAt(d.peek(),'X');
                    d.poll();
                    q.add(q.peek());
                    q.poll();
                    r.add(r.peek());
                    r.poll();
                }
            }
            else{
                if(r.size()==0) return "Dire";
                else{
                    sb.setCharAt(r.peek(),'X');
                   r.poll();
                    q.add(q.peek());
                    q.poll();
                    d.add(d.peek());
                    d.poll();
                }
            }
        }
        if(sb.charAt(q.peek())=='R') return "Radiant";
        return "Dire";
    }
}