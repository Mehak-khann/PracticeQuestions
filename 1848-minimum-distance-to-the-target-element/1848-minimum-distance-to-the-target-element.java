class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
       int val=Integer.MAX_VALUE;
       for(int i=0;i<nums.length;i++) {
        if(nums[i]==target){
            val=Math.min(val,Math.abs(i-start));
        }
       }
       
       return val;
    }
}