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
    public ListNode reverse(ListNode a){
      ListNode next=a;
        ListNode curr =a;
        ListNode prev=null;
    while(next!=null){
        next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
        return prev ;
    }    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        ListNode temp=head;
        ListNode a=null;
        ListNode b=null;
        ListNode c=null;
        ListNode d=null;
        int i=1;
        while(temp!=null){
            if(i==left-1) a=temp;
            if(i==left) b=temp;
            if(i==right+1) c=temp;
            if(i==right)d=temp;
            temp=temp.next;
            i++;
        }
        if(a!=null)a.next=null;
d.next =null;
        ListNode newSubHead=reverse(b);
       if(a != null) {
            a.next = newSubHead;
        } else {
            head = newSubHead; 
        }
        b.next = c;

        return head;
    }
}