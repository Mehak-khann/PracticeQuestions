class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        long sum=0;
        int[][] res=new int[n][2];
        for(int i=0;i<n;i++){
            res[i][0]=nums2[i];
            res[i][1]=nums1[i];
        }
        Arrays.sort(res,(a,b)->Integer.compare(b[0],a[0]));
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        long maxScore=0;    
        for(int i=0;i<k;i++){
            sum+=res[i][1];
            pq.add(res[i][1]);
            if(pq.size()>=k){
                maxScore=Math.max(maxScore,sum*res[i][0]);
                sum-=pq.peek();
                pq.poll();
            }
        }
        int i=1;
        int j=k;
        while(j<n){
            sum+=res[j][1];
            pq.add(res[j][1]);
            if(pq.size()>=k){
                maxScore=Math.max(maxScore,sum*res[j][0]);
                sum-=pq.peek();
                pq.poll();
        }
            i++;
            j++;
    }
        return maxScore;
}
}