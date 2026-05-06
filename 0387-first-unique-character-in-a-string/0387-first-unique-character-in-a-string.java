class Solution {
    public int firstUniqChar(String s) {
        int[] v=new int[26];
        for(int i=0;i<s.length();i++){
            v[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(v[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}