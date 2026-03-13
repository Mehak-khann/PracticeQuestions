class Solution {
    public int prio(char c){
        if(c=='+' || c=='-') return 1;
        if(c=='*' || c=='/') return 2;
        return 0;
    }
    public int solve(int val1,char c,int val2){
        if(c=='+') return val1+val2;
        if(c=='-') return val1-val2;
            if(c=='*') return val1*val2;
            if(c=='/') return val1/val2;
        return -1;
    }
    public int calculate(String s) {
    int n=s.length();
        Stack<Integer>val=new Stack<>();
        Stack<Character>op=new Stack<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)==' '){
                 continue;
                                }
            if(Character.isDigit(s.charAt(i))){
                int num=0;
                while(i<n && Character.isDigit(s.charAt(i))){
                    num=num*10+(s.charAt(i)-'0');
                    i++;
                }
                val.push(num);
                i--;
            }
            else{
                if(op.size()==0) op.push(s.charAt(i));
                else if(prio(s.charAt(i))>prio(op.peek())){
                    op.push(s.charAt(i));
                }
                else{
              while(op.size()>0 && prio(s.charAt(i))<=prio(op.peek())){
                        int val2=val.pop();
                        int val1=val.pop();
                        char op1=op.pop();
                        int ans=solve(val1,op1,val2);
                        val.push(ans);
                    }
                    op.push(s.charAt(i));
                }
                
            }
        }
        while(op.size()>0){
                        int val2=val.pop();
                        int val1=val.pop();
                        char op1=op.pop();
                        int ans=solve(val1,op1,val2);
                        val.push(ans);
        }
        return val.peek();
    }
}