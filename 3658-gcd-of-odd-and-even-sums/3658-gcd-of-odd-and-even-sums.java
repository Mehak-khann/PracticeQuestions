class Solution {
    // public void gcd(int a,int b,int[] val){

    //     if(a==0 || b==0){
    //         if(a>0){
    //             val[0]=a;
    //         }
    //         else{
    //             val[0]=b;
    //         }
    //         return;
    //     }
    //    if(a>b){
    //     gcd(a%b,b,val);
    //    }
    //    else{
    //     gcd(a,b%a,val);
    //    }
    // }
    public void gcd(int a, int b, int[] val) {
    // Standard base case: once the divisor (b) is 0,
    // the current dividend (a) is the GCD.
    if (b == 0) {
        val[0] = a;
        return;
    }
    // No need to check if a > b. 
    // If a < b, a % b is just a, which swaps the order automatically.
    gcd(b, a % b, val);
}
    public int gcdOfOddEvenSums(int n) {
        int sumEven =0;
        int sumOdd=0;
        // for(int i=1;i<=n;i++){
        //     if(i%2==0){
        //         sumEven+=i;
        //     }
        //     else{
        //         sumOdd+=i;
        //     }
        // }
        //int gcdValue=1;
        sumEven=(1+n)*n;
        sumOdd=n*n;
        int[] gcdValue=new int[1];
        //gcdValue[0]=1;
        
        gcd(sumEven,sumOdd,gcdValue);
        return gcdValue[0];

    }
}