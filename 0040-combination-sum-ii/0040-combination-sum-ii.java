class Solution {
    public void find(int i,int[] nums,List<Integer>curr,List<List<Integer>>res,int target){
        if(target==0){
         res.add(new ArrayList<>(curr));
            return;
        }
        if(i>=nums.length || target<0){
            return;
        }
        curr.add(nums[i]);
        find(i+1,nums,curr,res,target-nums[i]);
        int nextidx=i+1;
        while(nextidx<nums.length && nums[nextidx]==nums[i]){
            nextidx++;
        }
        curr.remove(curr.size()-1);
        find(nextidx,nums,curr,res,target);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
     Arrays.sort(candidates );
    List<Integer>curr=new ArrayList<>();
        find(0,candidates,curr,res,target);
        
        return res;
    }
}