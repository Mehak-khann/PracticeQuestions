class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
       int n=spells.length;
       int m=potions.length;
       int[] ans=new int[n];
       Arrays.sort(potions) ;
    //indices for potions
       for(int i=0;i<n;i++){
           int lo=0;
       int hi=m-1;
       while(lo<=hi){
        int mid=lo+(hi-lo)/2;
        if((long)spells[i]*potions[mid]>=success){
            hi=mid-1;
        }
        else{
            lo=mid+1;
        }
       }
       ans[i]=m-lo;
       }
       return ans;

    }
}