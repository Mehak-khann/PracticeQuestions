class Solution {
    public boolean isPossible(int mid,int[][] tasks){
        for(int i=0;i<tasks.length;i++){
            int actual=tasks[i][0];
            int minimum = tasks[i][1];

            if(minimum>mid){
                return false;
            }
            mid-=actual;
        }
        return true;
    }
    public int minimumEffort(int[][] tasks) {
        int lo=0;
        int hi=1000000000;
        int res=Integer.MAX_VALUE;
Arrays.sort(tasks, new Comparator<int[]>() {
         
            public int compare(int[] rowA, int[] rowB) {
                // Manually calculate the differences
              int diffA = rowA[1] - rowA[0];
        int diffB = rowB[1] - rowB[0];
        // in DESCENDING order.
       
         if (diffA > diffB) {
            return -1; // rowA comes first
        } else if (diffA < diffB) {
            return 1;  // rowB comes first
        } else {
            return 0;
        }
            }
        });
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isPossible(mid,tasks)){
                res=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return res;
    }
}