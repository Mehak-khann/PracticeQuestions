class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next ==null) return head; 
        ListNode a = head; 
        ListNode b = head.next; 
        while(b!=null){ 
            while(b!=null && b.val == a.val){
                b = b.next; 
            } 
            a.next = b; 
            a=b;
            if(b!=null) b = b.next;
        }
        return head;
    }
}