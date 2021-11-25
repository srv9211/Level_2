/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA==null || headB==null)
            return null;
        
        ListNode n1 = headA;
        ListNode n2 = headB;
        int count = 0;
        while(n1!=n2){
            n1 = n1.next;
            n2 = n2.next;
            if(n1==null && n2==null){
                return null;
            }
            if(n1==null){
                n1=headB;
                count++;
            }
            if(n2==null){
                n2=headA;
                count++;
            }
        }
        return n1;
    }
}
