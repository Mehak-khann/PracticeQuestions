// class Solution {
//     public int[] findPermutation(int[] nums) {
//         int n = nums.length;
//         List<List<Integer>> res = new ArrayList<>();
        
//         // Populate the list with starting values [0, 1, 2, ..., n-1] to permute
//         List<Integer> ans = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             ans.add(i);
//         }

//         // 1. Generate all permutations using your exact helper
//         calculate(0, ans, res, nums);

//         int resultMinScore = Integer.MAX_VALUE;
//         List<Integer> bestPerm = null;

//         // 2. Iterate through your res list and use your exact solve method to score them
//         for (int i = 0; i < res.size(); i++) {
//             int score = solve(res.get(i), nums);
//             if (score < resultMinScore) {
//                 resultMinScore = score;
//                 bestPerm = res.get(i);
//             }
//         }

//         // Convert the best match back to an int[] array
//         int[] finalResult = new int[n];
//         for (int i = 0; i < n; i++) {
//             finalResult[i] = bestPerm.get(i);
//         }
//         return finalResult;
//     }

//     // Your exact permutation helper structure
//     public void calculate(int i, List<Integer> ans, List<List<Integer>> res, int[] nums) {
//         if (i == ans.size()) {
//             // Replaced the repetitive .get(0) loop with a proper snapshot copy
//             res.add(new ArrayList<>(ans));
//             return;
//         }

//         for (int j = i; j < nums.length; j++) {
//             swap(ans, i, j);
//             calculate(i + 1, ans, res, nums);
//             swap(ans, i, j); // Backtrack
//         }
//     }

//     // Your exact scoring function structure
//     public int solve(List<Integer> res, int[] nums) {
//         int ans = 0; // Initialized to 0 instead of MAX_VALUE so addition works
//         for (int i = 0; i < res.size() - 1; i++) {
//             ans += Math.abs(res.get(i) - nums[res.get(i + 1)]);
//         }
//         ans += Math.abs(res.get(res.size() - 1) - nums[res.get(0)]);
//         return ans;
//     }

//     // List-based swap implementation to match your call pattern
//     private void swap(List<Integer> list, int i, int j) {
//         int temp = list.get(i);
//         list.set(i, list.get(j));
//         list.set(j, temp);
//     }
// }

class Solution{
     int minSum =Integer.MAX_VALUE;

    public void solve(int[] nums,boolean[] visited,List<Integer>temp,int sum,int n,List<Integer>res){
        if(minSum<=sum){
            return;
        }
        if(temp.size()==n){
            //added only that modulo condition
            int totalSum = sum + Math.abs(temp.get(temp.size() - 1) - nums[temp.get(0)]);
            if(totalSum<minSum){
                minSum=totalSum;
                res.clear();
                // res=new ArrayList<>(temp);
                res.addAll(temp);
            }
            return;
        }
        //The reason the loop starts at 0 every single time is because backtracking needs to evaluate every unused number for the current position, regardless of whether that number is smaller or larger than the ones we've already placed.

        for(int i=0;i<n;i++){
            if(visited[i]==false){
                visited[i]=true;
                temp.add(i);
                //score 0 to n-2
                int cost = Math.abs(temp.get(temp.size() - 2) - nums[temp.get(temp.size() - 1)]);

                solve(nums,visited,temp,sum+cost,n,res);
                temp.remove(temp.size()-1);
                visited[i]=false;
            }
        }

    }
    public int[] findPermutation(int[] nums){
        int n=nums.length;
        boolean[] visited=new boolean[n];
        List<Integer>res =new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        visited[0]=true;
        temp.add(0);
        solve(nums,visited,temp,0,n,res);
        int[] finalRes = new int[n];
        for(int i=0;i<n;i++){
            finalRes[i] = res.get(i);
        }
        return finalRes;

    }
}