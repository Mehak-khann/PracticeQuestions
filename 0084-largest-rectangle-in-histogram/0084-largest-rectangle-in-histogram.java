class Solution {
    public int[] prevSmaller(int[] heights ){
        int n=heights.length;
        int[] res=new int[n];
        Stack<Integer>st=new Stack<>();
        st.push(0);
        res[0]=-1;
        for(int i=1;i<n;i++){
    if(heights[st.peek()]<heights[i]){
                res[i]=st.peek();
                 st.push(i);
            }
            else{
                while(!st.isEmpty() &&(heights[st.peek()]>=heights[i])){st.pop();
            }
                if(st.isEmpty()){
                    res[i]=-1;
                }
                else{
                    res[i]=st.peek();
                }
        
        st.push(i);}
        }
            return res;
        }
        public int[] nextSmaller(int[] heights){
            int n=heights.length;
        int[] res=new int[n];
        Stack<Integer>st=new Stack<>();
        st.push(n-1);
        res[n-1]=n;
        for(int i=n-2;i>=0;i--){
    if(heights[st.peek()]<heights[i]){
                res[i]=st.peek();
                 st.push(i);
            }
            else{
                while(!st.isEmpty() && heights[st.peek()]>=heights[i]){st.pop();
            }
                if(st.isEmpty()){
                    res[i]=n;
                }
                else{
                    res[i]=st.peek();
                }
                st.push(i);
        }
        }
            return res;
    
        }
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] prevS=prevSmaller(heights);
        int[] nextS= nextSmaller(heights);
        int maxArea=0;
        for(int i=0;i<n;i++){
            int width=nextS[i]-prevS[i]-1;
            int area= width*heights[i];
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}