class Solution {
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int lo=0;
        int hi=1;
        int c=0;
        for(int i=2;i<n;i++){
            lo=0;
            hi=i-1;
            while(lo<hi){
                if(nums[lo]+nums[hi]>nums[i]){
                    c+=hi-lo;
                    hi--;
                }
                else{
                    lo++;
                }
            }
        }
        return c;
    }
}