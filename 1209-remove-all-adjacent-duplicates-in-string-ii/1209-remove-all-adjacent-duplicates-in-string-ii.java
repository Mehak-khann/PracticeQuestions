class Solution {
    class Node{
        char ch;
        int c;
        Node(char b,int a){
            c=a;
            ch=b;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Node>st =new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && st.peek().ch==s.charAt(i)){
                st.peek().c++;
                if(st.peek().c==k){
                    st.pop();
                }
            }
            else{
                st.push(new Node(s.charAt(i),1));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            Node nd=st.pop();
            for(int i=0;i<nd.c;i++){
                sb.append(nd.ch);
            }
        }
       return sb.reverse().toString();
        
    }
}