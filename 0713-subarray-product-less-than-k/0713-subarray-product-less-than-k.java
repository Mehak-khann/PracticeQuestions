class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0 || k==1)return 0;
        int n=nums.length;
        int i=0;
        int j=0;
        int sum=1;
        int count=0;
        while(j<n){
            sum*=nums[j];
            while(i<n && sum>=k){
                sum=sum/nums[i];
                i++;
            }
          count+=j-i+1;
          j++;
        }
        return count;
    }
}