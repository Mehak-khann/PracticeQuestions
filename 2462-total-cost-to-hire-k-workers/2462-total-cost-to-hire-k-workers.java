class Solution {
    public long totalCost(int[] costs, int k, int candidate) {
        int n=costs.length;
        if(candidate*2>=n){
            Arrays.sort(costs);
           long sum=0;
            for(int i=0;i<k;i++){
                sum+=costs[i];
            }
            return sum;
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{if(a[0]==b[0]){
            return a[1]-b[1];
        }
    else return a[0]-b[0];
                                                          }
    );
        long sum=0;
        int left=0;
        int right=n-1;
        for(int i=0;i<candidate;i++){
          pq.add(new int[]{costs[left],left});
            left++;
        }
        for(int i=0;i<candidate;i++){
        //pq.add(new int[]{costs[n-i-1],n-i-1});
            if(right>=left){
               pq.add(new int[]{costs[right],right});
            
            right--;
            }
        }
        
        while(k>0){
            int[] top=pq.poll();
            sum+=top[0];
            if(left>right){
                k--;
                continue;
            }
            if(left>top[1]){
                pq.add(new int[]{costs[left],left});
                left++;
            }
            else{
                pq.add(new int[]{costs[right],right});
                right--;
            }
            k--;
        }
        return sum;
    }
}