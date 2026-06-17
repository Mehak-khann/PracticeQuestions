class Solution {
    int m,n;
    int result;
    int nonObstacles;
    public void backtracking(int[][] grid,int count,int r,int c){
        if(r<0 || r>=m || c<0 || c>=n || grid[r][c]==-1){
            return;
        }

        if(grid[r][c]==2){
            if(count==nonObstacles){
                result++;
            }
            return;
        }
        int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};
        grid[r][c]=-1;
        for(int[] d:direction){
            int newR =r+d[0] ;
            int newC=c+d[1];
            backtracking(grid,count+1,newR,newC);
        }
        grid[r][c]=0;
    }
    public int uniquePathsIII(int[][] grid) {
    m=grid.length;
    n=grid[0].length;
    
    result=0;
    nonObstacles =0;
     int startX=0;
     int startY = 0;
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==0){
                nonObstacles++;

            }
            if(grid[i][j]==1){
                startX=i;
                startY=j;
            }
        }
    }
    nonObstacles++;
    int count=0;
    //parameter count is for counting  all 0s for answer in the grid 
    // global result is for how many have all zeros
    backtracking(grid,count,startX,startY);
    return result;
    }
}