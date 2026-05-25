class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length; 

        int i = 0;
        int j = m - 1;
        
        while (i <= j) {
            // 1. Find the middle column index (fixed 'ri' to 'j')
            int mid = i + (j - i) / 2;
            
            // 2. Find the row index of the MAXIMUM number in this column
            int maxRow = 0; 
            for (int row = 0; row < n; row++) {
                if (mat[row][mid] > mat[maxRow][mid]) {
                    maxRow = row; // Updates our maximum row tracker
                }
            }

            int curr = mat[maxRow][mid];
            
            // 3. Check the left neighbor safely (fixed 'rows' to 'maxRow')
            int leftneigh = -1;
            if (mid - 1 >= 0) {
                leftneigh = mat[maxRow][mid - 1];
            }

            // 4. Check the right neighbor safely (fixed 'mrows' to 'maxRow')
            int rightNeighbor = -1;
            if (mid + 1 < m) {
                rightNeighbor = mat[maxRow][mid + 1];
            }
            
            // 5. If currentNumber is bigger than both left and right, it is a 2D peak
            if (curr > leftneigh && curr > rightNeighbor) {
                int[] result = new int[2];
                result[0] = maxRow;
                result[1] = mid;
                return result; 
            }

            // 6. Binary search adjustment
            if (leftneigh > curr) {
                j = mid - 1; 
            } 
            else {
                i = mid + 1;  
            }
        }

        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        return res;
    }
}