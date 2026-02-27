class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            if(asteroids[i]>0){
                st.push(asteroids[i]);
            }
            else{
                while(!st.isEmpty()&& st.peek()>0 && st.peek()<(-asteroids[i])){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()==(-asteroids[i]) ){
                    st.pop();
                }
                else if(st.isEmpty() || st.peek()<0){
                    st.push(asteroids[i]);
                }
            }
        }
        int idx=st.size()-1;
        int[] res=new int[st.size()];
        while(!st.isEmpty()){
            res[idx]=st.pop();
            idx--;
        }
        return res;
    }
}