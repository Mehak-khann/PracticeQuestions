class Solution {
    boolean search(int[] nums,int lo,int hi,int target){
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==target){
                return true;
            }
            else if(nums[mid]>target){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return false;

    }
    public boolean search(int[] nums, int target) {
        int n=nums.length;
       
        boolean flag=true;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                flag=false;
                break;
            }
        }
        if(flag==true){
            return search(nums,0,n-1,target);
        }
         int arr[] = new int[n+n];
         int idx=0;
         for(int i=0;i<n+n;i++){
            arr[i]=nums[idx];
            idx++;
            if(idx==n){
                idx=0;
            }
         }

         int pivot=-1;
         for(int i=1;i<n+n;i++){
            if(arr[i]<arr[i-1]){
                pivot=i;
                break;
            }
         }
         return search(arr,pivot,pivot+n-1,target);

    }
}