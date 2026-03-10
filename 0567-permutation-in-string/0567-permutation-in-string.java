class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n>m)return false;
        int[] one=new int[26];
        int[] two=new int[26];
        for(int i=0;i<n;i++){
            one[s1.charAt(i)-'a']++;
        }
        int k=n;
        for(int i=0;i<k;i++){
            two[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(one,two)){
            return true;
        }
        int i=1;
        int j=k;
        while(j<m){
            two[s2.charAt(j)-'a']++;
            two[s2.charAt(i-1)-'a']--;
            if(Arrays.equals(two,one)){
                return true;
            }
            i++;
            j++;
        }
        return false;
            
    }
}