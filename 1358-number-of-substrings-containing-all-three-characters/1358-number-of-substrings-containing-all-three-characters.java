//backtracking got some problem ...
/*
class Solution {
    public void backtracking(String s,int i,StringBuilder sb,List<String>res){
        if(i==s.length()){
            // if(sb.contains('a') && sb.contains('b') && sb.contains('c')){
            if(sb.indexOf("a")!=-1 && sb.indexOf("b")!=-1 && sb.indexOf("c")!=-1){
                res.add(new StringBuilder(sb).toString());
            }
            return;
        }
        sb.append(s.charAt(i));
        backtracking(s,i+1,sb,res);
        // sb.remove();
        sb.deleteCharAt(sb.length()-1);
        backtracking(s,i+1,sb,res);

    }
    public int numberOfSubstrings(String s) {
        int n=s.length();
        
        List<String>res=new ArrayList<>();
        StringBuilder sb= new StringBuilder();
        backtracking(s,0,sb,res);
        return res.size();
    }
}

*/


//corrected backtracking appraoch ...but still getting TLE
/*
class Solution {
    
    public void backtracking(String s, int i, StringBuilder sb, List<String> res) {
        // Base case: if we reach the end of the string, stop this branch
        if (i == s.length()) {
            return;
        }
        
        // 1. Take the current character (forces it to be contiguous)
        sb.append(s.charAt(i));
        
        // 2. Check if the current contiguous string has all three characters
        if (sb.indexOf("a") != -1 && sb.indexOf("b") != -1 && sb.indexOf("c") != -1) {
            res.add(sb.toString()); 
        }
        
        // 3. Recurse to add the very next character in the string
        backtracking(s, i + 1, sb, res);
        
        // 4. Backtrack (remove the character) so the StringBuilder is 
        // clean when we start a new substring from the outer loop
        sb.deleteCharAt(sb.length() - 1);
    }

    public int numberOfSubstrings(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        // Start a completely new contiguous substring from EVERY index
        for (int start = 0; start < s.length(); start++) {
            backtracking(s, start, sb, res);
        }
        
        return res.size();
    }
}
*/
class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int lastA=-1;
        int lastB =-1;
        int lastC=-1;

        int minIdx=-1;
        int ans=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a')lastA=i;
            else if(s.charAt(i)=='b')lastB=i;
            else lastC=i;

            minIdx=Math.min(lastA,Math.min(lastB,lastC));
            if(minIdx!=-1){
                ans+=minIdx+1;
            }

        }
        return ans;
    }
}