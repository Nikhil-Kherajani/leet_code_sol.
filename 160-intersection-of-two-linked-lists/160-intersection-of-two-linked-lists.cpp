class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode * h1 = headA;
        ListNode * h2 = headB;
        if(h1 == NULL || h2 == NULL)
        { return NULL; }
        while(h1 != h2)
        {
            h1 = h1 ? h1 -> next: headB;
            h2 = h2 ? h2 -> next: headA;
    }
     return h1;   
    }};