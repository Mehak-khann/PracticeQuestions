class Solution {
    public int calculate(String s,int[] weights){
        int n=s.length();
        int nums=0;
        for(int i=0;i<n;i++){
            nums+=weights[s.charAt(i)-'a'];
        }
        return nums;
    }
    public String mapWordWeights(String[] words, int[] weights) {
        int n=words.length;
        StringBuilder ans=new StringBuilder();
       for(int i=0;i<n;i++){
            String s=words[i];

            int val1=calculate(s,weights);
            
            int rem = val1%26;
            ans.append((char)('z'-rem));

        }
        return ans.toString();
        
    }
}