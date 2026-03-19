class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n=pushed.length;
        int m=popped.length;
        Stack<Integer>st=new Stack<>();
int idx=0;
        for(int i=0;i<n;i++){
            st.push(pushed[i]);

            while(!st.isEmpty() && i<m && st.peek()==popped[idx]){
                st.pop();
                idx++;

            }

        }
        return st.size()==0;
    }
}