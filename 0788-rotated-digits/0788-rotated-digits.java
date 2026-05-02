class Solution {
    public boolean check(int n){
        boolean ans=false;
        while(n>0){
            int last=n%10;
            if(last==3 || last==7 || last==4){
                return false;
            }
            if(last==2 || last==5 || last==6 || last==9){
                ans=true;
            }
            n=n/10;
        }
        return ans;
        // if(n==3 || n==4 || n==7 || n%10==0|| n%3==0 ||n%7==0 || n%4==0 || n%8==0){
        //     return false;
        // }
        // String s =n+"";
        // if(s.contains("3") || s.contains("4") || s.contains("7")){
        //     return false;
        // }
        // int rev=0;
        // while(n>0){
        //     int last=n%10;
        //     if(last==2){
        //         rev=rev*10+5;
        //     }
        //     else if(last==5){
        //         rev=rev*10+2;
        //     }
        //     else if(last==6){
        //         rev=rev*10+9;
        //     }
        //     else if(last==9){
        //         rev=rev*10+6;
        //     }
        //     else{
        //         rev=rev*10+last;
        //     }
        //     n=n/10;
        // }
        // if(s.equals(rev+"")){
        //     return false;
        // }
        // return true;
    }
    public int rotatedDigits(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            if(check(i)){
                count++;
            }
        }
        return count;
    }
}