class Solution {
    public int maxFrequency(int[] nums, int k) {
        // int n=nums.length;
        // Arrays.sort(nums);
        // int sum=0;
        // int costNeeded=0;
        // int res=0;
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         costNeeded=0;
        //         int target=nums[j];
        //         for(int p=i;p<=j;p++){
        //             costNeeded=costNeeded+(target-nums[p]);
        //         }
        //         if(costNeeded<=k){
        //             res=Math.max(res,j-i+1);
        //         }
        //     }
        // }
        // return res;
        Arrays.sort(nums);
        int n =nums.length;
        long sum=0;
        int res=0;
        int i=0;
        int j=0;
        long cost=0;
        while(j<n){
            sum+=nums[j];
            cost=(long)nums[j]*(j-i+1)-sum;
            while(i<n && cost>k){
                sum-=nums[i];
                i++;//as window is shrinking this loop then we have again again check for operation
                cost=(long)nums[j]*(j-i+1)-sum;

            }
            res=Math.max(res,j-i+1);
            j++;

        }
        return res;
    }
}