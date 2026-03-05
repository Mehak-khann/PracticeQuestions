class Solution {
    public int maxDepth(String s) {
        int m = 0; // Max depth
        int c = 0; // Total count of '(' found
        
        if (s.length() <= 1) return 0;

        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            if (current == '(') {
                st.push(current);
                c++;
                // Update max depth whenever we push
                m = Math.max(m, st.size());
            } else if (current == ')') {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
        }
        
        if (c == 0) return 0;
        return m;
    }
}