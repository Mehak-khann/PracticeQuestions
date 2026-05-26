class Solution {
    public int numberOfSpecialChars(String word) {
        int n=word.length();
        int[] freq1=new int[26];
        int[] freq2=new int[26];
        for(int i=0;i<n;i++){
            if(Character.isLowerCase(word.charAt(i))){
                freq1[word.charAt(i)-'a']++;
            }
            else{
                freq2[word.charAt(i)-'A']++;
            }
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(freq1[i]!=0 && freq2[i]!=0){
                count++;
            }
        }
        return count;

    }
}