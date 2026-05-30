class Solution {
    public int lowerBound(int[] first,int target){
        int lo=0;
        int hi=first.length -1;
        int res=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(first[mid]<=target){
                res=mid+1;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return res;
    }
     public int upperBound(int[] first,int target){
        int lo=0;
        int hi=first.length -1;
        int res=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(first[mid]<target){
               res=mid+1;
                lo=mid+1;
             
            }
            else{
                 hi=mid-1;   
            }
        }
        return res;
    }
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n=flowers.length;
        int m=flowers[0].length;

        int[] res= new int[people.length];
        int[] first=new int[n];
        int[] second=new int[n];
        for(int i=0;i<n;i++){
            first[i]=flowers[i][0];
            second[i]=flowers[i][1];
        }
        Arrays.sort(first);
        Arrays.sort(second);
        for(int i=0;i<people.length;i++){
            // int greater=upperBound(first,people[i]);
            // int smaller=lowerBound(second,people[i]);
            int started = lowerBound(first, people[i]);  
    int finished = upperBound(second, people[i]);
            res[i]=started-finished;
        }
        return res;

    }
}