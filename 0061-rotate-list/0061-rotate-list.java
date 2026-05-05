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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        int n=0;
        ListNode temp=head;
        ListNode tail=null;        while(temp!=null){
            if(temp.next==null) tail=temp;
            temp=temp.next;
            n++;
        }
        k=k%n;
        
        int idx=n-k;
        
        temp=head;
        for(int i=0;i<idx-1;i++){
            temp=temp.next;
        }
        tail.next=head;
        head=temp.next;
        temp.next=null;
        return head;
    }
}