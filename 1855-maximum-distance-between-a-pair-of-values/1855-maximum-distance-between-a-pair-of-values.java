class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
       int n=nums1.length;
       int m=nums2.length;
       int i=0;
       int j=0;
       int absolute=Integer.MIN_VALUE;
       while(j<m && i<n){
        if(j<m && nums1[i]<=nums2[j] && i<=j){
            absolute=Math.max(absolute,Math.abs(i-j));
            j++;
        }
        else if(j==i){
            j++;
            i++;
        }
        else{
        i++;
        }
       }
       if(absolute==Integer.MIN_VALUE){
        return 0;
       }
       return absolute;
    }
}