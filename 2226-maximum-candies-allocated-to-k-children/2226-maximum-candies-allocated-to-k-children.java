class Solution {
    public boolean distribute(int[] candies,long k, int mid){
        int n=candies.length;
        int rem=candies[0];
        long count=0;
        for(int i=0;i<n;i++){
            if(mid!=0)
            // count=(candies[i]/mid)+count;
            rem=candies[i]/mid;
            count+=rem;
            if(count>=k){
                return true;
            }
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        int n =candies.length;
        int lo=1;
        int hi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            hi=Math.max(candies[i],hi);
        }
        int res=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(distribute(candies,k,mid)){
                res=Math.max(res,mid);
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return res;
    }
}