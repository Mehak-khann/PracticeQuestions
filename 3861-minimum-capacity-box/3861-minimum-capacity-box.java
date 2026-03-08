class Solution {
    public int minimumIndex(int[] capacity, int itemsize) {
        int n=capacity.length;
        int idx=-1;
        int cap=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(capacity[i]==itemsize ){
               // return i;
                idx=i;
                break;
            }
            if(capacity[i]>itemsize && cap>capacity[i]){
                cap=capacity[i];              idx=i;
            }
        }
        return idx;
    }
}