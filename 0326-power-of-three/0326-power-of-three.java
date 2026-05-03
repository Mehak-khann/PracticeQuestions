class Solution {
    public boolean ans(int n){
        if(n==0 || n==2){
            return false;}
        if(n==1){
            return true;
        }
            if(n%3==0){
        return ans(n/3);
            }
            else{
                return false; }
       //     return false;            
    }  
        public boolean isPowerOfThree(int n) { 
            if(n<=0) return false;
                                          return ans(n);
        //return false;
    }
}