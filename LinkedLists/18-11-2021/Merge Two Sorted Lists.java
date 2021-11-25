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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        else if(l2==null)
            return l1;
        ListNode h = null;
        ListNode pre = null;
        if(l1.val < l2.val){
            h = l1;
            pre = l1;
            l1 = l1.next;
        }
        else{
            h = l2;
            pre = l2;
            l2 =  l2.next;
        }
        
        while( l1 != null && l2 !=null){
            if(l1.val < l2.val){
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            }
            else{
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }
        if(l1!=null){
            pre.next = l1;
        }
        else if(l2!=null){
            pre.next = l2;
        }
        return h;
        
    }
}
