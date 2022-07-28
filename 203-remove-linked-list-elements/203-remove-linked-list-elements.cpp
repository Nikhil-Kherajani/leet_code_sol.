class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* cur = head, *prev =new ListNode(-1);
        prev->next = head;
        ListNode* res = prev;
        while(cur)
        {
            if(cur->val != val)
            {
                prev = cur;
                cur = cur->next;
            }
            else
            {
                if(!cur->next)
                    prev->next = nullptr;
                else
                    prev->next = cur->next;
                cur = cur->next;
            }
        }
        return res->next;
    }
};