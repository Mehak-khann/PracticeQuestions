class Solution {
    public int solve(int v1,String op,int v2){
        if(op.equals("+")) return v1+v2;
        if(op.equals("-")) return v1-v2;
        if(op.equals("*")) return v1*v2;
        if(op.equals("/")) return v1/v2;
        return 0;
    }
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*")){
                int v2=st.pop();
                int v1=st.pop();
                int ans=solve(v1,tokens[i],v2);
                st.push(ans);
        }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.peek();
    }
}