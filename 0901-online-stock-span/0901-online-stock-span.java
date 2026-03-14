class StockSpanner {
    Stack<Integer>st;
    ArrayList<Integer>l;
    int i;
    public StockSpanner() {
       st=new Stack<>();
        l=new ArrayList<>();
        i=0;
    }
    
    public int next(int price) {
        l.add(price);
        int curr;
        if(i==0){
            //first entry
            st.push(i);
            curr=1;// because it include today as well
        }
        else{
            if(l.get(st.peek())>price){
                curr=i-st.peek();
                st.push(i);
            }
            else{
                while(st.size()>0 && l.get(st.peek())<=price){
                    st.pop();
                }
                if(st.size()>0){
                    curr=i-st.peek();
                }
                else{
                    curr=i-0+1;
                }
                st.push(i);
            }
        }
        i++;
        return curr;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */