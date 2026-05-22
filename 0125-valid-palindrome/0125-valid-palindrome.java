 class Solution {
    public boolean isPalindrome(String s) {
        List<Character> c = new ArrayList<>(); 
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {  
                c.add(Character.toLowerCase(ch));
            }
        } 
        int i = 0;
        int j = c.size() - 1;
        while (i < j) {
            if (c.get(i) != c.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
}