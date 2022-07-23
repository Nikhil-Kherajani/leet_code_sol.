class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* curr = head;
        if(head==NULL)
            return head;
        while(curr->next != NULL){
            if(curr->val == (curr->next)->val){
                curr->next = curr->next->next;
                continue;
            }
            curr=curr->next;
            if(curr==NULL)
                break;
        }
        return head;
    }
};