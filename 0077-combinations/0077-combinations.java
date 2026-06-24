class Solution {
    public void backtracking(int start,int n,int k,List<Integer>ans,List<List<Integer>>res){
        if(k==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(start<=n){
        ans.add(start);
        backtracking(start+1,n,k-1,ans,res);
        ans.remove(ans.size()-1);
        backtracking(start+1,n,k,ans,res);
        }
        else{
            return;
        }
    }
    public List<List<Integer>> combine(int n, int k) {
     List<List<Integer>>res=new ArrayList<>();
     List<Integer>ans=new ArrayList<>();
     backtracking(1,n,k,ans,res);
     return res;
    }
}