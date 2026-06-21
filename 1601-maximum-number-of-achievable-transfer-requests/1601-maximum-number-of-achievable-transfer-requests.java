class Solution {
    public void backtracking(int[][]requests,int i,int count,int[] res,int[] ans){
        if(i>=requests.length){
            boolean allZero =true;
            for(int j=0;j<ans.length;j++){
                if(ans[j]!=0){
                    allZero=false;
                    break;
                }
            }
            if(allZero==true){
                res[0]=Math.max(count,res[0]);
            }
            return;

        }
        ans[requests[i][0]]-=1;
        ans[requests[i][1]]+=1;
         backtracking(requests,i+1,count+1,res,ans);
        ans[requests[i][0]]+=1;
        ans[requests[i][1]]-=1; 
        backtracking(requests,i+1,count,res,ans);
    }
    public int maximumRequests(int n, int[][] requests) {
        int m=requests[0].length;
        int[] ans =new int[n];
        int count=0;
        int[] result=new int[1];
        backtracking(requests,0,count,result,ans);
        return result[0];
    }
}