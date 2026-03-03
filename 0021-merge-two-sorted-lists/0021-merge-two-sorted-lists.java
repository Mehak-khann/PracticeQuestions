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
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode c=new ListNode(100);
        ListNode temp=c;
        while(a!=null && b!=null){
            if(a.val<=b.val){
                temp.next=a;
                a=a.next;
                temp=temp.next;
            }
            else{
                temp.next=b;
                b=b.next;
                temp=temp.next;
            }
        }
        if(a==null) temp.next=b;
        else temp.next=a;
        return c.next;
    }
}