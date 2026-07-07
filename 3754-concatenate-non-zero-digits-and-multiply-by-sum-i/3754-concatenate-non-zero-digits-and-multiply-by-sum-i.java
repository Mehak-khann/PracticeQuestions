class Solution {

    public long sumAndMultiply(int n) {
        String s =n+"";
        long sum=0;
        long val=0;
      
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='0'){
                val =val*10+(s.charAt(i)-'0');
                sum+=(s.charAt(i)-'0');
            }
        }
        return val*sum;
        
    }
}