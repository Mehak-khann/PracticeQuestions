class Solution {
    public void find(int i,int[] nums,List<Integer>curr,List<List<Integer>>res,int target){
        if(target==0){
           res.add(new ArrayList<>(curr));
            return;
        }
        if(target<0 || i>=nums.length){
            return;
        }
        curr.add(nums[i]);
        find(i,nums,curr,res,target-nums[i]);
        curr.remove(curr.size()-1);
        find(i+1,nums,curr,res,target);
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
     List<Integer>curr=new ArrayList<>();
        find(0,candidates,curr,res,target);
        return res;
    }
}