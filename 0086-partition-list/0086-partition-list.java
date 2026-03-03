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
    public ListNode partition(ListNode head, int x) {
        ListNode lo=new ListNode(100);
        ListNode hi=new ListNode(100);
        ListNode templo=lo;
        ListNode temphi=hi;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                templo.next=temp;
                temp=temp.next;
                templo=templo.next;
            }
            else{
                temphi.next=temp;
                temp=temp.next;
                temphi=temphi.next;
            }
        }
        templo.next=hi.next;
       temphi.next=null;
        return lo.next;
    }
}