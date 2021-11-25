/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null)
            return head;
        
        // copy same node in front of every node
        Node temp = head;
        while(temp != null){
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }
         // pointing random towards copy ones
        temp = head;
        while(temp != null){
            if(temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        // DELETI NG THOSE NODES WHICH WERE COPIED AND RETURNING
        //     THE COPIED ONES
        Node ret = head.next;
        temp = head;
        while(temp!=null){
            Node n = temp.next;
            temp.next = n.next;
            if(n.next == null)
                return ret;
            n.next = n.next.next;
            temp = temp.next;
        }
        return ret;
    }
}
