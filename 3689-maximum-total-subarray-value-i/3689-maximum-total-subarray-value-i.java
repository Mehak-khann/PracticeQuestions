class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long ans=-1;
        int n=nums.length;
        int maxV=Integer.MIN_VALUE;
        int minV =Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
          maxV=Math.max(nums[i],maxV);
          minV=Math.min(nums[i],minV);
        }
        for(int i=0;i<k;i++){
            ans+=maxV-minV;
        }
        return ans +1;
    }
}