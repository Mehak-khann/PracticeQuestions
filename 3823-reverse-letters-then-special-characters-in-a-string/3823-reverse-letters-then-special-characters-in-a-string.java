class Solution {
    public String reverseByType(String s) {
        int n=s.length();
      Stack<Character>st=new Stack<>();
      Stack<Character>ch=new Stack<>();
      for(int i=0;i<n;i++){
        if(s.charAt(i)>='a' && s.charAt(i)<='z'){
            st.push(s.charAt(i));
        }
        else{
            ch.push(s.charAt(i));
        }
      }
      String g="";
      int k=0;
      int j=0;
      for(int i=0;i<n;i++){
        if(s.charAt(i)>='a' && s.charAt(i)<='z'){
        g+=st.pop();
        }
        else{
   g+=ch.pop();
        }
      }
      return g;
    }
}