class Solution {
    public void find(int r,int c,int i,char[][]board,String word,boolean[] flag){
        if(i==word.length()){
            flag[0]=true;
            return;
        }
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]!=word.charAt(i)){
            return;
        }

        char original = board[r][c];
        board[r][c]='#';
        find(r-1,c,i+1,board,word,flag);
        find(r+1,c,i+1,board,word,flag);
        find(r,c-1,i+1,board,word,flag);
        find(r,c+1,i+1,board,word,flag);

       board[r][c]=original;


    }
    public boolean exist(char[][] board, String word) {
       int n=board.length;
       int m=board[0].length;
       int w =word.length();
       boolean[] flag =new boolean[1];
       for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++){
          find(i,j,0,board,word,flag);
          if(flag[0]==true){
            return true;
          }
        }
       }
       return false;
    }
}