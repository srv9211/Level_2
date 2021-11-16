//==========================JAVA

class Solution {
    public ListNode reverseList(ListNode head) {        
        if(head==null)
            return null;
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr!=null){
            ListNode fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
}

//================================CPP

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if(head==nullptr)
            return nullptr;
        ListNode* prev = nullptr;
        ListNode* curr = head;
        
        while(curr!=nullptr){
            ListNode* fwd = curr->next;
            curr->next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
    }
};
