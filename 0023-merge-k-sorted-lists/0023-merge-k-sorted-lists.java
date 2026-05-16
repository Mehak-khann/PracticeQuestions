class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode c = new ListNode(100);
        ListNode temp = c;
        while(a != null && b != null){
            if(a.val <= b.val){
                temp.next = a;
                temp = temp.next;
                a = a.next;
            }
            else{
                temp.next = b;
                temp = temp.next;
                b = b.next;
            }
        }
        if(a == null) temp.next = b;
        else temp.next = a;
        return c.next;
    }

    public ListNode mergeKLists(ListNode[] arr) {
        if(arr.length == 0) return null;
        
        int n = arr.length;
        while(n > 1){
            ListNode a = arr[0];
            for(int i = 0; i < n - 1; i++){
                arr[i] = arr[i+1];
            }
            n--;
            
            ListNode b = arr[0];
            for(int i = 0; i < n - 1; i++){
                arr[i] = arr[i+1];
            }
            n--;
            
            ListNode c = mergeTwoLists(a, b);
            arr[n] = c;
            n++;
        }
        return arr[0];
    }
}