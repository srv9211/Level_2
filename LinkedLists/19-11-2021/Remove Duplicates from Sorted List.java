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
        ListNode curr = head.next;
        ListNode pre = head;
        while(curr!=null){
            if(pre.val != curr.val){
                pre.next = curr;
                pre = pre.next;
                curr = curr.next;
            }
            else{
                curr = curr.next;
                if(curr==null){
                    pre.next = curr;
                    return head;
                }
            }
        }
        return head;
        
    }
}
