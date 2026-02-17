class Solution {
    public int myAtoi(String s) {
        int n = 0;
        boolean flag = false;  // negative flag
        int i = 0;
        int len = s.length();
        while (i < len && s.charAt(i) == ' ') {
            i++;
        }
        if (i < len && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                flag = true;
            }
            i++;
        }
        while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            // Overflow check
            if (n > Integer.MAX_VALUE / 10 || 
                (n == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > 7)) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            n = n * 10 + (s.charAt(i) - '0');
            i++;
        }
        
        
        if (flag==true) {
            n = -n;
        }
        
        return n;
    }
}
