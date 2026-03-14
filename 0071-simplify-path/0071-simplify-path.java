class Solution {
    public String simplifyPath(String path) {
        /* don't work if we have to go back more than 1 time...
            
        int n=path.length();
        String[] arr= path.split("/+");
        StringBuilder sb=new StringBuilder("");
        StringBuilder prev=new StringBuilder("");
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals("..")){
                sb=prev;
            }
            else if(arr[i].equals(".")){
                continue;
            }
            else{
                prev=new StringBuilder (sb.toString().substring(0,sb.length()-1));
                sb.append(arr[i]);
                if(i<arr.length-1) sb.append("/");
                
            }
        }
        return sb.toString();
        */

        String[] s=path.split("/+");
        Stack<String>st=new Stack<>();
        for(int i=0;i<s.length;i++){
            if(st.size()>0 && s[i].equals("..")){
                st.pop();
            }
             if(s[i].equals("..")){
                 continue;             }
            else if(s[i].equals(".") || s[i].equals("")){
                continue;
            }
            else{
                
                st.push(s[i]);
            }
        }
        StringBuilder sb=new StringBuilder();
        /* reverse problem->  /home becomes emoh....
        while(st.size()>0){
            sb.append(st.peek());
            if(st.size()>1) sb.append("/");
            st.pop();
        }
        */
    
        if(st.isEmpty()) return "/";
        for (int i = 0; i < st.size(); i++) {
    sb.append("/");
    sb.append(st.get(i)); // Use .get(i) to access elements without popping them
        }
        return sb.toString();
    }
}