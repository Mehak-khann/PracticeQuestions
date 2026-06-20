class Solution {
    private boolean isPallindrome(String s){
        int n=s.length();
        int i=0;
        int j=n-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void backtracking(String s, int i,List<String>ans,List<List<String>>res){
        if(i==s.length()){
            res.add(new ArrayList(ans));
            return ;
        }
        if(i>s.length()){
            return;
        }
        for(int j=i;j<s.length();j++){
            if(isPallindrome(s.substring(i,j+1))){
                //starting point is fixed
                ans.add(s.substring(i,j+1));
                backtracking(s,j+1,ans,res);
                ans.remove(ans.size()-1);
            }

        }

    }
    public List<List<String>> partition(String s) {
        int i=0;
        List<String>ans=new ArrayList<>();
        List<List<String>>res=new ArrayList<>();
        backtracking(s,i,ans,res);
        return res;
    }
}