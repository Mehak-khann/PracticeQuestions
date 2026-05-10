class Solution {
    public void swap(int[] nums,int start,int i){
        int temp=nums[start];
        nums[start]=nums[i];
        nums[i]=temp;
    }
    public void calculate(int[] nums,int start,List<List<Integer>>res){
        if(start==nums.length){
            List<Integer> sub=new ArrayList<>();
            for(int n:nums){
                sub.add(n);
            }
            res.add(sub);
            return;
        }

        for(int i=start;i<nums.length;i++){
            swap(nums,start,i);
            calculate(nums,start+1,res);
            swap(nums,start,i);
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        List<List<Integer>>res=new ArrayList<>();
        calculate(nums,0,res);
        return res;
    }
}