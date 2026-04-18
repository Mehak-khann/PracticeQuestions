class Solution {
    public int reverse(int n){
        int rev=0;
        while(n>0){
           int last=n%10;
            rev=rev*10+last;
            n=n/10;
            
        } 
    return rev;
    }
    public int mirrorDistance(int n) {
        if(n<=9)return  0;
        int ans=reverse(n);
        int diff=Math.abs(n-ans);
        return diff;
    }
}