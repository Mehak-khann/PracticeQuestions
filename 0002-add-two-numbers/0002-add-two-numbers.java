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
    public ListNode rev(ListNode l1){
        ListNode next=l1;
        ListNode curr=l1;
        ListNode prev=null;
        while(next!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public void space(ListNode l1){
        while(l1!=null && l1.val==0){
            l1=l1.next;
        }
      //  return l1;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode dummy=new ListNode(0);
        ListNode c=dummy;
        space(l1);
        space(l2);
      //  l1=rev(l1);
     //   l2=rev(l2);
        while(l1!=null || l2!=null || carry!=0){
            int sum=carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;  
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            carry=sum/10;
            ListNode t=new ListNode(sum%10);
            c.next=t;
            c=t;
        }
       // return dummy.next;
     //   dummy.next=rev(dummy.next);
        return dummy.next;
    }
}