class Solution {
    public boolean check(int[] nums) {
        int n=nums.length;
        boolean flag=true;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                flag=false;
                break;
            }
        }
        if(flag==true){
            return true;
        }
        int[] arr=new int[n+n];
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
        for(int i=pivot;i<pivot+n-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
}