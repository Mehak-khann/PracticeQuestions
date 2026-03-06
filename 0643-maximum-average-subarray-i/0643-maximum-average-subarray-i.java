class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        double sum=0.0;
        double avg=0.0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        avg=sum/k;
        double maxRes=avg;
        int i=1;
        int j=k;
        while(j<n){
            sum=sum-nums[i-1]+nums[j];
            avg = sum/k;
            
            maxRes=Double.valueOf(Math.max(maxRes,avg));
            j++;
            i++;
        }
        return maxRes;
        
    }
}