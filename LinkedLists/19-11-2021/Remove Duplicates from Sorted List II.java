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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode curr = head;
        while(curr.next != null){
            ListNode fwd = curr.next;
            if(curr.val!=fwd.val){
                pre = pre.next;
                curr = curr.next;
            }
            else{
                while(curr.val == fwd.val){
                    curr = curr.next;
                    fwd = fwd.next;
                    if(fwd==null){
                        pre.next = fwd;
                        return dummy.next;
                    }
                }
                pre.next = fwd;
                curr = pre.next;
            }
        }
        return dummy.next;
    }
}
