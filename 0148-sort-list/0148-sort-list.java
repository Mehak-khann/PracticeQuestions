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
    public ListNode mergeSort(ListNode a,ListNode b){
        ListNode c= new ListNode(100);
        ListNode tempC=c;
        while(a!=null && b!=null){
            if(a.val<b.val){
                tempC.next=a;
                a=a.next;
                tempC=tempC.next;
            }
            else{
              tempC.next=b;
                b=b.next;
                tempC=tempC.next;
                
            }
        }
        if(a==null) tempC.next=b;
        else tempC.next=a;
        return c.next;
    }
    
    public ListNode sortList(ListNode head) {
     if(head==null || head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
             }
        ListNode a=head;
        ListNode b=slow.next;
        slow.next=null;        a=sortList(a);
        b=sortList(b);
        ListNode c=mergeSort(a,b);
        return c;
    }
}