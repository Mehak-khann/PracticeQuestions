class Solution {
    public void backtracking(int[] nums, int i, List<Integer>ans,List<List<Integer>>res){
        if(i==nums.length){
            if(ans.size()>=2){
          //  res.add(ans); if we add this we adding exact array which is geting modified over  and over  again ...this is the rason why we are getting empty array every single time
          res.add(new ArrayList(ans));//first make copy of that array and then add
            }
            return;
        }
        if(ans.size()==0 || (nums[i]>=ans.get(ans.size()-1))){
            ans.add(nums[i]);
            backtracking(nums,i+1,ans,res);
            ans.remove(ans.size()-1);
        }
        if (ans.size() > 0 && nums[i] == ans.get(ans.size() - 1)) {
            return; 
        }
        backtracking(nums,i+1,ans,res);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n =nums.length;
        List<List<Integer>>res =new ArrayList<>();
        int i=0;
        List<Integer>ans=new ArrayList<>();
        backtracking(nums,i,ans,res);
        return res;
    }
}

//approach 2

/*
class Solution {
    public void backtracking(int[] nums, int index, List<Integer> ans, List<List<Integer>> res) {
        if (ans.size() >= 2) {
            res.add(new ArrayList<>(ans)); // Snapshot copy (already fixed!)
        }

        // Use a HashSet to track elements used at the CURRENT level of recursion
        HashSet<Integer> used = new HashSet<>();

        for (int i = index; i < nums.length; i++) {
            // 1. Check if it maintains non-decreasing order
            // 2. Check if we've already picked this number at this step to avoid duplicates
            if ((ans.isEmpty() || nums[i] >= ans.get(ans.size() - 1)) && !used.contains(nums[i])) {
                used.add(nums[i]); // Mark this number as used for this position
                
                ans.add(nums[i]);
                backtracking(nums, i + 1, ans, res);
                ans.remove(ans.size() - 1); // Backtracking step
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        backtracking(nums, 0, ans, res);
        return res;
    }
}

*/