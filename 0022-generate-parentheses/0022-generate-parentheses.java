class Solution {
    public void calculate(int open,int close,int n,List<String>res,String ans){
        if(close==n){
           res.add(ans);
            return;
        }
        if(close>n){
            return;
        }
        if(open<n){
            calculate(open+1,close,n,res,ans+"(");
        }
        if(close<open){
            calculate(open,close+1,n,res,ans+")");
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        calculate(0,0,n,res,"");
        return res;
    }
}