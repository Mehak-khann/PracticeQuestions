class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n=arr.length;
        Deque<Integer>q=new ArrayDeque<>();
        ArrayList<Integer>res= new ArrayList<>();
        for(int i=0;i<k;i++){
            while(!q.isEmpty() && arr[q.peekLast()]<arr[i]){
                q.pollLast();
            }
            q.addLast(i);
        }
        for(int i=k;i<n;i++){
            res.add(arr[q.peekFirst()]);
            while(!q.isEmpty() && q.peekFirst()<=i-k){
                q.pollFirst();
            }
            while(!q.isEmpty() && arr[q.peekLast()]<arr[i]){
                q.pollLast();
            }
            q.addLast(i);
        }
        res.add(arr[q.peekFirst()]);
        int[] ans=new int[n-k+1];
        for(int i=0;i<ans.length;i++){
            ans[i]=res.get(i);
        }
        return ans;
    }
}