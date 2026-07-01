// class Solution {
//     public int calculate(String s,char[] letters,int[] score){
//         int sum =0;
//         HashMap<Character,Integer>mp = new HashMap<>();
        
//         for (char c : letters) {
//     // Increment the count, defaulting to 0 if the char isn't in the map yet
//     mp.put(c, mp.getOrDefault(c, 0) + 1);
// }
//         for(int i=0;i<s.length();i++){
//             if(mp.containsKey(s.charAt(i))){

//                 sum+=score[s.charAt(i)-'a'];
//             }
//         }
//         return sum;
//     }

//     public void backtracking(String[] words,char[] letters,int[] score,int i, int sum,int[] ans){
//         if(i==words.length){
//             if(ans[0]<sum){
//                 ans=sum;
//             }
//             return;
//         }
//         String s =words[i];
//         //calculate the score
//         int count = calculate(s,letters,score);
//         if(count>0){
//             sum+=count;
//         backtracking(words,letters,score,i+1,sum ,ans);

//         sum-=count;

//         }

//         backtracking(words,letters,score,i+1,sum,ans);

//     }
//     public int maxScoreWords(String[] words, char[] letters, int[] score) {
//         int n=words.length;
//       //  int m=char.length;
//         int p=score.length;
//         int[] ans=new int[1];
//         int sum=0;
//         backtracking(words,letters,score,0,sum,ans);
//         return ans[0];
//     }
// }

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];
        for (char ch : letters) {
            freq[ch - 'a']++;
        }
        
        // Use an array to store maxScore so it can be updated by reference
        int[] ans = new int[1]; 
        ans[0] = 0; // Initialize minimum score
        
        solve(0, score, words, 0, freq, ans);
        
        return ans[0];
    }

    private void solve(int i, int[] score, String[] words, int currScore, int[] freq, int[] ans) {
        // Update the maximum score found so far
        ans[0] = Math.max(ans[0], currScore);

        // Base case: no more words to process
        if (i >= words.length) {
            return;
        }

        // Option 1: Take words[i] (if possible)
        int[] tempFreq = Arrays.copyOf(freq, freq.length);
        int j = 0;
        int wordScore = 0;
        boolean canForm = true;

        while (j < words[i].length()) {
            char ch = words[i].charAt(j);
            tempFreq[ch - 'a']--;
            wordScore += score[ch - 'a'];

            if (tempFreq[ch - 'a'] < 0) {
                canForm = false;
                break;
            }
            j++;
        }

        if (canForm) {
            solve(i + 1, score, words, currScore + wordScore, tempFreq, ans);
        }

        // Option 2: Not Take words[i]
        // We pass the original freq here because we didn't modify it in this branch
        solve(i + 1, score, words, currScore, freq, ans);
    }
}