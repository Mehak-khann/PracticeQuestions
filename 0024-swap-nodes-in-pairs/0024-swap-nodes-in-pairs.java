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
    public void reverse(ListNode head,int steps){
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=curr;
        while(steps>0){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            steps--;
        }}
        public ListNode swapPairs(ListNode head) {
        int size=2;
        if(head==null){
            return head;
        }
        ListNode right=null;
        ListNode left=head;
        ListNode res=null;// the head to return as answer
         ListNode prevLeft=null;
        while(true){
            right=left;
            //can do right=left.next...but if not pair then it can of more than 2 size...for group of 2 or pair->2 nodes left is 1st node and roght is 2nd node .....but for group 4 ...left is 1st node and right is 4th node then right =left.next will only leads to 2nd node not to 4th node
            for(int i=0;i<(size-1);i++){
                if(right==null){
                    break;
                }
                // together for loop and break----> while(right!=null && i<(size-k))
                right=right.next;
            }

            if(right!=null){
                ListNode nextLeft=right.next;
                reverse(left,2);
                if(prevLeft!=null){
                    prevLeft.next=right;
                }
                prevLeft=left;
                if(res==null){
                    res=right;// for returning head in function we only need first head in pair that 1st head will be right,
                }
                left=nextLeft;
            }
            else{
                if(prevLeft!=null){
                    prevLeft.next=left;
                }
                if(res==null){
                    res=left;
                    
                }break;
            }
        }
        return res;
    }
}