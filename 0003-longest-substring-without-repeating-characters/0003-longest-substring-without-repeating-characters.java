class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n==0 || n==1) return n;
        Map<Character,Integer>mp=new HashMap<>();
        int i=0;
        int j=0;
        int res=Integer.MIN_VALUE;
        while(i<n && j<n){
            char a=s.charAt(j);
            mp.put(a,mp.getOrDefault(a,0)+1);
            while(j-i+1>mp.size()){
                  char c = s.charAt(i);
                  mp.put(c,mp.get(c)-1);
                  if(mp.get(c)==0){
                    mp.remove(c);
                  }
                  i++;
            }
            res=Math.max(res,j-i+1);
            j++;
        }
        return res;
    }
}