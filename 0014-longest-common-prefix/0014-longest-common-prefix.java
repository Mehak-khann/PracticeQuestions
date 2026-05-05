class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
       if(n==1) return strs[0];
         Arrays.sort(strs);
       String s = "";
      
       String first = strs[0];
       String last = strs[n-1];
        for(int i =0 ;i<(Math.min(first.length(),last.length()));i++){
        if(first.charAt(i)==last.charAt(i)){
            s+= first.charAt(i); 
        }
        else break;
    //  else return "" ;
        }
        return s;
    }
}