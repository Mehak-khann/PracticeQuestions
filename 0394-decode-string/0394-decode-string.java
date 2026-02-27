class Solution {
    public String decodeString(String s) {
        int n=s.length();
        Stack<Integer>num=new Stack<>();
        Stack<Character>ch=new Stack<>();
        for(int i=0;i<n;i++){
            if(Character.isDigit(s.charAt(i))){
                int val=0;
                while(i<n && Character.isDigit(s.charAt(i))){
               // num.push(s.charAt(i)-'0');
               val=val*10+(s.charAt(i)-'0');
                i++;
                }
                num.push(val);
                i--;
            }
            else if(s.charAt(i)==']'){
                StringBuilder temp=new StringBuilder("");
                while(!ch.isEmpty() && ch.peek()!='['){
                    //   temp.append(ch.pop());
                    temp.insert(0,ch.pop());
                }
                ch.pop();
                int nLength=num.pop();
                StringBuilder again=new StringBuilder("");
                for(int j=0;j<nLength;j++){
                    again.append(temp);
                }
                for(int j=0;j<again.length();j++){
                    ch.push(again.charAt(j));
                }
            }
            else{
                ch.push(s.charAt(i));
            }
        }
        StringBuilder temp=new StringBuilder("");
          while(!ch.isEmpty()){
                    //   temp.append(ch.pop());
                    temp.insert(0,ch.pop());
                }
                return temp.toString();
    }
}