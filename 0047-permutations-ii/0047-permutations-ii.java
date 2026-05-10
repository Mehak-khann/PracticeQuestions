class Solution {
    public void swap(int[] nums, int start,int i){

        int temp=nums[start];
        nums[start]=nums[i];
        nums[i]=temp;
    }
    public void calculate(int[] nums,int start,List<List<Integer>>res,HashSet<List<Integer>>s){
        if(start==nums.length){
            List<Integer>sub=new ArrayList<>();
            for(int n:nums){
                sub.add(n);
            }
            if(!s.contains(sub)){
                s.add(sub);
            res.add(sub);}
            return;
            
        }
        for(int i=start;i<nums.length;i++){
            swap(nums,start,i);
            calculate(nums,start+1,res,s);
            swap(nums,start,i);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        HashSet<List<Integer>>s=new HashSet<>();
        calculate(nums,0,res,s);
        return res;
    }
}