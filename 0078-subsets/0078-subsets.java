class Solution {
    public void calculate(int[] nums,int i,List<Integer>sub,List<List<Integer>>res){
        if(i==nums.length){
          //  res.add(sub);...empty copy getting store
          res.add(new ArrayList<>(sub));
            return;
        }
        // calculate(nums,i+1,sub.add(nums[i]),res);
        // sub.add() and sub.remove() return boolean so...boolean parameter is getting passed;
        // calculate(nums,i+1,sub.remove(sub.size()-1),res);
        sub.add(nums[i]);
        calculate(nums,i+1,sub,res);
        sub.remove(sub.size()-1);
        calculate(nums,i+1,sub,res);
    }
    public List<List<Integer>>subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>subs=new ArrayList<>();
        calculate(nums,0,subs,res);
        return res;
    }
}