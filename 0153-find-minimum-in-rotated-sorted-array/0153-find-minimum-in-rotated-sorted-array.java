class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int lo=0;
        int hi=n-1;
        int res=-1;
        if(nums[lo]<nums[hi]) return nums[lo];
        while(lo<=hi){
          int mid = lo+(hi-lo)/2;
          if(nums[mid]>nums[n-1]){
            lo=mid+1;
          }
          else{
            res=nums[mid];
            hi=mid-1;
          }
        }
        return res;
    }
}