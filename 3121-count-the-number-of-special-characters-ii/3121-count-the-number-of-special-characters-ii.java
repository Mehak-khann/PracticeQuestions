class Solution {
    public int numberOfSpecialChars(String word) {
    int n=word.length();
    int[] lowerfreq=new int[26];
    int[] upperfreq=new int[26];


    for(int i=0;i<26;i++){
        lowerfreq[i]=-1;
        upperfreq[i]=-1;
    }
    for(int i=0;i<n;i++){
        if(Character.isLowerCase(word.charAt(i))){
        lowerfreq[word.charAt(i)-'a']=i;
        }
    }
    for(int i=0;i<n;i++){
        if(!Character.isLowerCase(word.charAt(i)))
        upperfreq[word.charAt(i)-'A']=i;
    }
    int count=0;
    for(int i=0;i<26;i++){
        if(lowerfreq[i]!=-1 && upperfreq[i]!=-1){
            if(lowerfreq[i]<upperfreq[i]){
            count++;
            }
        }
    }
    return count;

    }
}