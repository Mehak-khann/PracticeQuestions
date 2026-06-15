class Solution {
    public boolean isPerfectSquare(int num) {
        // long val= num;
        long hi=num;
        long lo=0;
        while(lo<=hi){
            long mid=lo+(hi-lo)/2;
            if((mid*mid)==num){
                return true;
            }
            else if((mid*mid)>num){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return false;
    }
}