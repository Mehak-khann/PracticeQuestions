class Solution {
    public long rev(long n) {
        long r = 0;
        while (n > 0) {
            long last = n % 10;
            r *= 10;
            r += last;
            n /= 10;
        }
        return r;
    }
    
    public boolean isPalindrome(int x) {
        long a = (long) x;
        long r = rev(a);
        if (r == a) return true;
        else return false;
    }
}















































