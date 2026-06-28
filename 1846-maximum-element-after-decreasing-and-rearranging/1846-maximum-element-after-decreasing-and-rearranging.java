class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        arr[0]=1;
        for(int i=1;i<n;i++){
            int diff = Math.abs(arr[i-1]-arr[i]);
            if(diff>1){
                arr[i]=arr[i-1]+1;
            }
        }
        int m = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            m=Math.max(m,arr[i]);
        }
        return m;
    }
}