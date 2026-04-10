class Solution {
    public void find(int i,int[] nums,List<Integer>curr,List<List<Integer>>res,int k,int target){
        
        if(target==0 && curr.size()==k){
        res.add(new ArrayList<>(curr));
            return;
        }
        if(curr.size()>=k) return;
        if(i>=nums.length) return;
        curr.add(nums[i]);
        find(i+1,nums,curr,res,k,target-nums[i]);
       curr.remove(curr.size()-1);
      find(i+1,nums,curr,res,k,target);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>curr=new ArrayList<>();
        int[] nums={1,2,3,4,5,6,7,8,9};
        find(0,nums,curr,res,k,n);
        return res;
    }
}