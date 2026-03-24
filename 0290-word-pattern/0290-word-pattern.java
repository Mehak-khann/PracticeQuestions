import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
    
        String[] words = s.split(" ");
    
        if (pattern.length() != words.length) {
            return false;
        }
        Map<String, Character> wordToChar = new HashMap<>();
        Set<Character> usedChars = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char pChar = pattern.charAt(i);
            String word = words[i];

        
            if (!wordToChar.containsKey(word)) {
                if (usedChars.contains(pChar)) {
                    return false;
                }
                wordToChar.put(word, pChar);
                usedChars.add(pChar);
            } else {
                if (wordToChar.get(word) != pChar) {
                    return false;
                }
            }
        }

        return true;
    }
}