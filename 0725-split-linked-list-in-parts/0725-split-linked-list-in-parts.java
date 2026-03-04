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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp=head;
         int n=0;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
       // List<ListNode>ans=new LinkedList<>();
        ListNode[] ans=new ListNode[k];
        
        int size=n/k;
        int rem=n%k;
        temp=head;
        int idx=0;
        while(temp!=null && idx<k){
            ListNode c=new ListNode(100);
            ListNode tempC=c;
            int s=size;
            if(rem>0){
                s++;
                rem--;
            }
            for(int i=1;i<=s;i++){
                tempC.next=temp;
                temp=temp.next;
                tempC=tempC.next;                     }
            tempC.next=null;
            ans[idx]=c.next;
            idx++;
        }
        if(ans.length<k){
            int extra=k-ans.length;
            for(int i=1;i<=extra;i++){
                ans[idx]=null;
                idx++;
            }
        }
        return ans;
    }
}