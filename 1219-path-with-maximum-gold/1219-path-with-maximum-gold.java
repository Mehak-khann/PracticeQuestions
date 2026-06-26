class Solution {
    public void backtracking(int[][]grid,int i,int j,int ans,int[] res ){
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0 || grid[i][j]==0){
            
            return;
        }

        ans+=grid[i][j];
        res[0] =Math.max(res[0],ans);

        int original = grid[i][j];
        grid[i][j]=0;
 int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
 for(int[] d: dir){
    int new_i = i+d[0];
    int new_j = j+d[1];
    backtracking(grid,new_i,new_j,ans,res);
 }
 grid[i][j]=original;
    }
    public int getMaximumGold(int[][] grid) {
        int n=grid.length;
        int m= grid[0].length;
        int[] res=new int[1];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    //start calling fromm this ith and jth cell
                    //ans[0]=0;
                    backtracking(grid,i,j,ans,res);
                }
            }
        }
        return res[0];
    }
}