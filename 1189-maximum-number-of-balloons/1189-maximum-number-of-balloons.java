class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        HashMap<Character, Integer> np = new HashMap<>();
        HashMap<Character, Integer> mp = new HashMap<>();
        
        String s = "balloon";
        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (int i = 0; i < n; i++) {
            np.put(text.charAt(i), np.getOrDefault(text.charAt(i), 0) + 1);
        }
        
        int res = Integer.MAX_VALUE;
        for (HashMap.Entry<Character, Integer> x : mp.entrySet()) {
            char c = x.getKey();
            int need = x.getValue();
            int have = np.getOrDefault(c, 0);
            int t = have / need;
            res = Math.min(res, t);
        }
        return res;
    }
}