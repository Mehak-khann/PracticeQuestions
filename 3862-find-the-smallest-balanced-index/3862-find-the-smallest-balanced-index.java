class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n=nums.length;
        if(n==1) return -1;
        long[] pre=new long[n];
        long[] suff=new long[n];
        pre[0]=0;
        suff[n-1]=1;
        for(int i=1;i<=n-1;i++){
            pre[i]=pre[i-1]+nums[i-1];
        }
        int ans=-1;
       if(pre[n-1]==1){
           ans=n-1;
       }
        for(int i=n-2;i>=0;i--){
            suff[i]=suff[i+1]*nums[i+1];
            if(suff[i]==pre[i]){
                ans=i;
            }
            if(suff[i]>pre[i]){
                if(ans!=-1) return ans;
                else return  -1;            }
        }
         
        return ans;
    }
}