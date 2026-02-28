class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n=sandwiches.length;
        Queue<Integer>q=new LinkedList<>();
        int m=students.length;
        for(int i=0;i<m;i++){
            q.add(students[i]);
        }
        int count=0;
        int i=0;
        while(q.size()>0 && count!=q.size()){
            if(q.peek()==sandwiches[i]){
                count=0;
                i++;
                q.poll();
            }
            else{
                count++;
                q.add(q.peek());
                q.poll();
            }
        }
        return q.size();
    }
}