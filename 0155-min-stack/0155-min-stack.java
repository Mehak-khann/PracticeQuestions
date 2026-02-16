class MinStack {
   Stack<Integer>st;
   Stack<Integer>MiniStack;
    public MinStack() {
        st=new Stack<>();
        MiniStack=new Stack<>();
    }
    
    public void push(int val) {
        if(MiniStack.isEmpty() || val<=MiniStack.peek()){
            MiniStack.push(val);
        }
        st.push(val);
    }
    
    public void pop() {
        if(!MiniStack.isEmpty() &&  st.peek().equals(MiniStack.peek())){
            MiniStack.pop();
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return MiniStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */