class Solution {
    public static int find(int[] nums){
        int n=nums.length;
        int lo=0;
        int hi=n-1;
        if(nums[lo]<nums[hi]) return lo;
        int res=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]>nums[n-1]){
                lo=mid+1;
            }
            else{
                res=mid;
                hi=mid-1;
            }
        }
        return res;
    }
    public static int binary(int[] nums,int lo, int hi,int target){
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int n=nums.length;
        int pivot =find(nums);
        int idx=binary(nums,0,pivot-1,target);
        if(idx!=-1) return idx;
        return binary(nums,pivot,n-1,target);
    }
}