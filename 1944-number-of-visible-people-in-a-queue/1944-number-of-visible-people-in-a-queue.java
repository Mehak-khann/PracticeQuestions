class Solution {
    public int[] canSeePersonsCount(int[] heights) {
      int n=heights.length;
      int[] ans=new int[n];  
      ans[n-1]=0;
      Stack<Integer>st=new Stack<>();
      st.push(heights[n-1]);
      int count=0;
      for(int i=n-2;i>=0;i--){
        count=0;
        while(!st.isEmpty() && st.peek()<heights[i]){
            st.pop();
            //count number of perople the ith one can see
            count++;
        }
        if(!st.isEmpty()){
            //take this person as well
            count++;
        }
        ans[i]=count;
        st.push(heights[i]);
      }
      return ans;
    }
}