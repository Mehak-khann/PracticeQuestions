class Solution {
    public ListNode reverse(ListNode head){
        ListNode Next=head;
        ListNode curr=head;
        ListNode prev=null;
        while(Next!=null){
            Next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=Next;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode temp =head;
        int m=Integer.MIN_VALUE;
        int sum=0;
        ListNode slow = temp;
        ListNode fast=temp;
        int c=0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            c++;
        }
        //slow is at right middle
        fast=reverse(slow);
        temp = head;
        while(c>0){
            sum=temp.val  + fast.val;
            m = Math.max(sum,m);
            temp=temp.next;
            fast=fast.next;
            c--;
        }
return  m;
        
    }
}