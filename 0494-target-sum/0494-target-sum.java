class Solution {

    int count=0;
    public void find(int start,int[] nums,int target ){
        if(start==nums.length){
            if(target==0){
                count++;
            }
            return;
        }
        // if(start>=nums.length)
        find(start+1,nums,target-nums[start]);
        find(start+1,nums,target-(-nums[start]));
    }
    public int findTargetSumWays(int[] nums, int target) {
        find(0,nums,target);
        return count;
    }
}