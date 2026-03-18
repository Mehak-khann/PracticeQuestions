class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n=maze.length;
        int m=maze[0].length;
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{entrance[0],entrance[1],0});
        maze[entrance[0]][entrance[1]]='+';
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        while(q.size()>0){
            int[] curr=q.poll();
            for(int[] d:dir){
                int r=curr[0]+d[0];
                int c=curr[1]+d[1];
                int step =curr[2];
                if(r>=0 && r<n && c>=0 && c<m && maze[r][c]=='.'){
                    if(r==0 || r==n-1|| c==0 || c==m-1){
                        return step+1;
                    }
                    maze[r][c]='+';
                    q.add(new int[]{r,c,step+1});
                }
            }
        }
        return -1;
    }
}