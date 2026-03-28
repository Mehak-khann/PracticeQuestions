class Solution {
    public int strCopy(String s,int i,int n,String sub,int m){
      if(i+m>n){
        return -1;
      }
      if(s.substring(i,i+m).equals(sub)){
        return i;
      }
      int ans=strCopy(s,i+1,n,sub,m);
      return ans;
    }
    public int strStr(String haystack, String needle) {

        int n=haystack.length();
        int m=needle.length();
        if(n==m){
            if(haystack.equals(needle)){
                return 0;
            }
            return -1;
        }
        int idx=strCopy(haystack,0,n,needle,m);
        return idx;
    }
}