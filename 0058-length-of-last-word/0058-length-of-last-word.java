class Solution {
    public int lengthOfLastWord(String s) {
        int  n=s.length();
        int i=n-1;
        while(s.charAt(i)==' '){
            i--;
        }
        int count=0;
        for(int j=i;j>=0;j--){
            if((s.charAt(j)>=65 && s.charAt(j)<=90) || (s.charAt(j)>=97 && s.charAt(j)<=122)){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}