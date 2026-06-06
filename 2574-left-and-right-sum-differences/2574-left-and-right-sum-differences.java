class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int pre=0;
        int total=0;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        int[] res=new int[n];
        for(int i=0;i<n;i++){ 
            pre+=nums[i];
            int right=total -pre;
            int left=pre-nums[i];
            res[i]=Math.abs(right-left);
            
        }
        return res;
    }
}