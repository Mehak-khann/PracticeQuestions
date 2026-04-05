class Solution {
    void reversepart(int i, int j,int[]nums){
         while(i<=j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
    i++;
    j--;
} 
    }
    public void rotate(int[] nums, int k) {
         int n = nums.length;
        if(k==n) return;
        if(k>n) k=k%n;
        reversepart(0,n-1-k,nums);
        reversepart(n-k,n-1,nums);
        reversepart(0,n-1,nums);
        return ;
    }
}