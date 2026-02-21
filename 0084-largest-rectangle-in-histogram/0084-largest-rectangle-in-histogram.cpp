class Solution {
public:
    vector<int> prevSmaller(vector<int>heights){
     int n=heights.size();
     stack<int>s;
     vector<int>res(n,-1);
     //default -1;
     res[0]=-1;
     s.push(0);
     for(int i=1;i<n;i++){
        if(heights[i]<=heights[s.top()]){
            while(!s.empty() && heights[i]<=heights[s.top()]){
                s.pop();
            }
            if(!s.empty()){
                res[i]=s.top();
            }
            else{
                res[i]=-1;
            }
            s.push(i);
        }
        else{
            res[i]=s.top();
            s.push(i);
        }
     }
     return res;
    }

     vector<int> nextSmaller(vector<int>heights){
        int n=heights.size();
        stack<int>st;
        vector<int>res(n,n);
        res[n-1]=n;
        //defaut value is n
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            if(heights[i]>heights[st.top()]){
                res[i]=st.top();
                st.push(i);
            }
            else{
                while(!st.empty() && heights[i]<=heights[st.top()]){
                    st.pop();
                }
                if(st.empty()){
                    res[i]=n;
                }
                else{
                    res[i]=st.top();
                }
                st.push(i);
            }
        }
        return res;
    }

    int largestRectangleArea(vector<int>& heights) {
        vector<int>prevS = prevSmaller(heights);
        vector<int>nextS= nextSmaller(heights);
      int n=heights.size();
        int maxArea=0;
        for(int i=0;i<n;i++){
            int wid = nextS[i]-prevS[i]-1;
            int area=wid*heights[i];
            maxArea=max(maxArea,area);
        }
        return maxArea;
    }
};