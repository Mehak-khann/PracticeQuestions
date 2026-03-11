class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        Stack<Integer>st=new Stack<>();
        //calculating next smallest
        int[] ans=new int[n];
        //better try to push indices in stack as j!=i
        ans[n-1]=prices[n-1];
        st.push(ans[n-1]);
        for(int i=n-2;i>=0;i--){
            if(st.size()>0 && st.peek()<=prices[i])
            {
                ans[i]=prices[i]-st.peek();
                st.push(prices[i]);
            }
            else{
                
                while(st.size()>0 && st.peek()>prices[i]){
                    st.pop();
                }
                if(st.size()==0){
                    ans[i]=prices[i];
                }
                else ans[i]=prices[i]-st.peek();
                st.push(prices[i]);
            }
        }
        return ans;
    }
}