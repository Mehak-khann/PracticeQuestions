class Solution {
    public boolean isPowerOfTwo(int n) {
        //iterative
    //     public boolean isPowerOfTwo(int n) {
    //  if(n<=0)    return false;
    //  while(n%2==0){
    //     n=n/2;
    //  }
    //  if(n==1) return true;
    //  return false;
    //     }
    
        //recursive
        if(n==1){
            return true;
        }
        if(n==0){
            return false;
        }
        if(n%2==0)
        return  isPowerOfTwo(n/2);
        else return false;
    }
}