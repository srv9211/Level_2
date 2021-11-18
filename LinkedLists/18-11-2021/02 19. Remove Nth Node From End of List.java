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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        for(int i=0; i<n; i++)
            fast = fast.next;
        
        if(fast==null){
            ListNode temp = slow;
            slow = slow.next;
            temp.next = null;
            return slow;
        }
        
        while(fast.next!=null){    
            slow = slow.next;
            fast = fast.next;
        }
        ListNode temp = slow.next.next;
        slow.next.next = null;
        slow.next = temp;
        return head;
    }
}
