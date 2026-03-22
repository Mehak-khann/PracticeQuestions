class Solution {
    public void reverse(int[] mat){
        int n=mat.length;
        int i=0;
        int j=n-1;
        while(i<j){
            int temp=mat[i];
                mat[i]=mat[j];
                mat[j]=temp;
                i++;
                j--;
            
        }
    }
    public int[][] checkRotation(int[][]mat){
        int n =mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            reverse(mat[i]);
        }
        return mat;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        for(int i=0;i<4;i++){
            if(Arrays.deepEquals(checkRotation(mat),target)){
                return true;
            }
        }
        return false;

    }
}