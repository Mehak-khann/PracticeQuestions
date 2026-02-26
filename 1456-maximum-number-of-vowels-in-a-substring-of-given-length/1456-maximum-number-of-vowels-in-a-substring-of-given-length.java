class Solution {
    public int maxVowels(String s, int k) {
     int n=s.length();
     int[] alpha =new int[26];//default will be 0
     int count=0;
     int maxRes=0;
     for(int i=0;i<k;i++){
        if(s.charAt(i)-'a'==0 || s.charAt(i)-'a'==4 || s.charAt(i)-'a'==8 || s.charAt(i)-'a'==14 || s.charAt(i)-'a'==20){
            count++;
        }
     }
     maxRes=count;
    int i=1;
    int j=k;
    while(j<n){
         if(s.charAt(i-1)-'a'==0 || s.charAt(i-1)-'a'==4 || s.charAt(i-1)-'a'==8 || s.charAt(i-1)-'a'==14 || s.charAt(i-1)-'a'==20){
            count--;
        }
         if(s.charAt(j)-'a'==0 || s.charAt(j)-'a'==4 || s.charAt(j)-'a'==8 || s.charAt(j)-'a'==14 || s.charAt(j)-'a'==20){
            count++;
        }
        maxRes=Math.max(maxRes,count);
        i++;
        j++;
    }
    return maxRes;


    }
}