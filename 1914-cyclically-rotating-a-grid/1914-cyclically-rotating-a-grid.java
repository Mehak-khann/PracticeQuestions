// class Solution {
//         void reversepart(int i, int j,List<Integer>nums){
//          while(i<=j){
//     int temp = nums.get(i);
//     nums.get(i) = nums.get(j);
//     nums.get(j) = temp;
//     i++;
//     j--;
// } 
//     }
   
//     public void rotation(List<Integer>nums,int[][] res,int k,int[] pointer){
//               int n = nums.size();
//         if(k==n) return;
//         if(k>n) k=k%n;
//rotate right
//         reversepart(0,n-1-k,nums);
//         reversepart(n-k,n-1,nums);
//         reversepart(0,n-1,nums);

//            //0-->minr
//        //1-->minc
//        //2-->maxr
//        //3-->maxc
//        int w=0;
//        while(w<nums.size()){
//          for(int j =pointer[1];j<=pointer[3];j++){
//             // v.add(matrix[minr][j]);
//             res[pointer[0]][j]=nums.get(w);
//             w++;
//         }
//         pointer[0]++;
//         if(pointer[0]>pointer[2] || pointer[1]>pointer[3]) break;
//         //down
//         for(int i =pointer[0];i<=pointer[2];i++){
//             // v.add(matrix[i][maxc]);
//             res[i][pointer[3]]=nums.get(w);
//             w++;
//         }
//         pointer[3]--;
//           if(pointer[0]>pointer[2] || pointer[1]>pointer[3]) break;
//         //left
//         for(int j = pointer[3];j>=pointer[1];j--){
//             // v.add(matrix[maxr][j]);
//             res[pointer[2]][j]=nums.get(w);
//             w++;
//         }
//        pointer[2]--;
//          if(pointer[0]>pointer[2] || pointer[1]>pointer[3]) break;

//         //up
//         for(int i =pointer[2]; i>=pointer[0];i--){
//             // v.add(matrix[i][minc]);
//             res[i][pointer[1]]=nums.get(w);
//             w++;
//         }
//        pointer[1]++;
//        }


//     }
//     public int[][] rotateGrid(int[][] grid, int k) {
//         int m=grid.length;
//         int n=grid[0].length;

//         int[][] res=new int[m][n];  
//      int minr =0,minc = 0, maxr = m-1,maxc = n-1;
//        int[] pointer= new int[4];
//        //0-->minr
//        //1-->minc
//        //2-->maxr
//        //3-->maxc
//      while(minr<=maxr && minc <=maxc){
//         List<Integer>v=new ArrayList<>();
//         //right
//         for(int j =minc;j<=maxc;j++){
//             v.add(matrix[minr][j]);
//         }
//         minr++;
//         if(minr>maxr || minc>maxc) break;
//         //down
//         for(int i = minr;i<=maxr;i++){
//             v.add(matrix[i][maxc]);
//         }
//         maxc--;
//          if(minr>maxr || minc>maxc) break;
//         //left
//         for(int j = maxc;j>=minc;j--){
//             v.add(matrix[maxr][j]);
//         }
//         maxr--;
//          if(minr>maxr || minc>maxc) break;
//         //up
//         for(int i =maxr; i>=minr;i--){
//             v.add(matrix[i][minc]);
//         }
//         minc++;
//         rotation(v,res,k,pointer );
//      }
//         return res;
//     }
// }
 
class Solution {
 
    void reversepart(int i, int j, List<Integer> nums) {
        while (i < j) {
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
            i++;
            j--;
        }
    }

    public void rotation(List<Integer> nums, int[][] res, int k, int[] pointer) {
        int n = nums.size();
        k = k % n;  
        if (k == 0) {
            fillLayer(nums, res, pointer);
            return;
        } 
        reversepart(0, k - 1, nums);
        reversepart(k, n - 1, nums);
        reversepart(0, n - 1, nums);

        fillLayer(nums, res, pointer);
    }

    public void fillLayer(List<Integer> nums, int[][] res, int[] p) {
        int w = 0;
        int r1 = p[0], c1 = p[1], r2 = p[2], c2 = p[3];
        
        // Fill following the same spiral order
        for (int j = c1; j <= c2; j++){
            res[r1][j] = nums.get(w++);
        }
        for (int i = r1 + 1; i <= r2; i++){
            res[i][c2] = nums.get(w++);
        }
        for (int j = c2 - 1; j >= c1; j--){
            res[r2][j] = nums.get(w++);
        }
        for (int i = r2 - 1; i > r1; i--){
            res[i][c1] = nums.get(w++);
        }
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];

        int minr = 0, minc = 0, maxr = m - 1, maxc = n - 1;

        while (minr < maxr && minc < maxc) {
            List<Integer> v = new ArrayList<>();
            // Extract layer in clockwise order
            for (int j = minc; j <= maxc; j++){
                v.add(grid[minr][j]);
            }
            for (int i = minr + 1; i <= maxr; i++){
                v.add(grid[i][maxc]);
            }
            for (int j = maxc - 1; j >= minc; j--){
                v.add(grid[maxr][j]);
            }
            for (int i = maxr - 1; i > minr; i--){
                v.add(grid[i][minc]);
            }

            int[] layerBounds = {minr, minc, maxr, maxc};
            rotation(v, res, k, layerBounds);

            minr++; minc++; maxr--; maxc--;
        }
        return res;
    }
}