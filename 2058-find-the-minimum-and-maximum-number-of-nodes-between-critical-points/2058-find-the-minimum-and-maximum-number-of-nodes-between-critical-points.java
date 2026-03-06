/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode a=head;
        ListNode b=head.next;
        ListNode c=head.next.next;
        int[] res=new int[2];
        res[0]=-1;
                    res[1]=-1;
        if(c==null){ 
                    return res;}
       // List<Integer>ans=new LinkedList<>();
        ArrayList<Integer>ans=new ArrayList<>();
        int idx=2;
        while(c!=null){
           if((b.val<a.val && b.val<c.val) || (b.val>a.val && b.val>c.val)){
               ans.add(idx);
           }
            a=a.next;
            b=b.next;
            c=c.next;
            idx++;
        }
        int n=ans.size();
        if(n<2){
            return res;
        }
        int mindiff=Integer.MAX_VALUE;
       // int maxdiff=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
        mindiff=Math.min(mindiff,ans.get(i+1)-ans.get(i));
        }
        res[0]=mindiff;
        res[1]=ans.get(n-1)-ans.get(0);
        return res;
    }
}