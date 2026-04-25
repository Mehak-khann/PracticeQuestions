class Solution {
    public int[] prevSmall(int[] height){
        int n=height.length;
        Stack<Integer>st=new Stack<>();
        int[] res=new int[n];
        res[0]=-1;
        st.push(0);
        for(int i=1;i<n;i++){
            if(height[st.peek()]<height[i]){
                res[i]=st.peek();
                st.push(i);
            }
            else{
                while(st.size()>0 && height[st.peek()]>=height[i]){
                    st.pop();
                }
                if(st.size()==0){
                    res[i]=-1;
                }
                else{
                    res[i]=st.peek();
                }
                st.push(i);
            }
        }
        return res;
    }

    public int[] nextSmall(int[] height){
        int n=height.length;
        int[] res=new int[n];
        Stack<Integer>st=new Stack<>();
        res[n-1]=n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            if(height[st.peek()]<height[i]){
                res[i]=st.peek();
                st.push(i);
            }
            else{
                while(st.size()>0 && height[st.peek()]>=height[i]){
                    st.pop();
                }
                if(st.size()==0){
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
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] prev=new int[m];
        int[] next=new int[m];
        int maxArea=0;

     int[] height=new int[m];     
     for(int i=0;i<m;i++)  {
        height[i]=matrix[0][i]-'0';
     }
     prev=prevSmall(height);
     next=nextSmall(height);
    //  int maxArea=0;
     for(int k=0;k<m;k++){
        int width=next[k]-prev[k]-1;
        int area=width*height[k];
        maxArea=Math.max(maxArea,area);
     }
     for(int i=1;i<n;i++){
        for(int j=0;j<m;j++){
        if(matrix[i][j]=='0'){
             height[j]=0;
        }
        else{
            height[j]=height[j]+(matrix[i][j]-'0');
        }
        }
     
     //apply same largest histogram logic
    //  /int[] prev=new int[m];
    //  int[] next=new int[m];
     prev=prevSmall(height);
     next=nextSmall(height);
    //  int maxArea=0;
     for(int k=0;k<m;k++){
        int width=next[k]-prev[k]-1;
        int area=width*height[k];
        maxArea=Math.max(maxArea,area);
     }
     }
     return maxArea;
        
    }
}