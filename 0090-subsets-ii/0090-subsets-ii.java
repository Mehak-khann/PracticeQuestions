class Solution {
    public void calculate(int i,int[]nums,List<Integer>sub,List<List<Integer>>res,Set<List<Integer>>s){
        if(i==nums.length){
            if(!s.contains(new ArrayList<>(sub))){
                List<Integer>a=new ArrayList<>(sub);
                res.add(a);
                s.add(a);
            }
            return;
        }
        sub.add(nums[i]);
        calculate(i+1,nums,sub,res,s);
        sub.remove(sub.size()-1);
        calculate(i+1,nums,sub,res,s);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        // we sort because the set is considering [1,4] and[4,1] different and the question doesn't want that
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>sub=new ArrayList<>();
        Set<List<Integer>>s=new HashSet<>();
        calculate(0,nums,sub,res,s);
        return res;
    }
}