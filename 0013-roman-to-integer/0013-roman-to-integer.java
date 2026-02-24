class Solution {
    public int valAt(char a) {
        if (a == 'I') return 1;
        if (a == 'V') return 5;
        if (a == 'X') return 10;
        if (a == 'L') return 50;
        if (a == 'C') return 100;
        if (a == 'D') return 500;
        if (a == 'M') return 1000;
        return -1;
    }

    public int romanToInt(String s) {
        int i = 0;
        int ans = 0;
        int sub;
        
        while (i < s.length()) {
            if (i + 1 < s.length()) {
                if (valAt(s.charAt(i)) >= valAt(s.charAt(i + 1))) {
                    ans += valAt(s.charAt(i));
                } else {
                    sub = 0;
                    sub = valAt(s.charAt(i + 1)) - valAt(s.charAt(i));
                    ans += sub;
                    i++; 
                }
            } else {
        
                ans += valAt(s.charAt(i));
            }
            i++;
        }
        return ans;
    }
}