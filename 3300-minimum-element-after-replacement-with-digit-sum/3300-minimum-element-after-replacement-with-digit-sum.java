class Solution {
    public int sum(int n){
        int s=0;
        while(n>0){
            int last=n%10;
            s+=last;
            n=n/10;
        }
        return s;
    }
    public int minElement(int[] nums) {
        int n=nums.length;
       // int[] res=new int[n];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            nums[i]=sum(nums[i]);
            min=Math.min(min,nums[i]);
        }
       return min;  
    }
}