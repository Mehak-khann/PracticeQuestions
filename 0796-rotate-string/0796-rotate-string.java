class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        int m=goal.length();
        if(n!=m){
            return false;
        }
        for(int i=1;i<=n;i++){
            s=s.substring(1) + s.charAt(0);
            if(s.equals(goal)){
                return true;
            }
        }
        return false;
    }
}