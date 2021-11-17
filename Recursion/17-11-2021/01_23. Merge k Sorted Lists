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
    
    public ListNode merge(ListNode[] lists, int si, int ei){
        if(ei==si+1)
            return mergeTwoLists(lists[si], lists[ei]);
        else if(si==ei)
            return lists[ei];
        
        int mid = (si+ei)/2;
        
        ListNode l1 = merge(lists, si, mid);
        ListNode l2 = merge(lists, mid+1, ei);
        
        return mergeTwoLists(l1, l2);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        return merge(lists, 0, lists.length-1);
    }
}
