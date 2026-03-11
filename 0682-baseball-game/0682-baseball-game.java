class Solution {
    public int calPoints(String[] operations) {
        int n=operations.length;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            if(operations[i].equals("C") && st.size()>0){
                st.pop();
            }
            else if(operations[i].equals("D")){
                st.push(2*st.peek());
            }
            else if(operations[i].equals("+")){
                int a=st.pop();
                int b=st.peek();
                st.push(a);
                st.push(a+b);
            }
            else{
                st.push(Integer.parseInt(operations[i]));
            }
        }
        int sum=0;
        while(st.size()>0){
            sum+=st.pop();
        }
        return sum;
    }
}