class Solution {
public:
    ListNode* getmid(ListNode* head){
        ListNode* slow=head;
        ListNode* fast=head;
        while(fast->next && fast->next->next){
            slow=slow->next;
            fast=fast->next->next;
        }
        return slow;
    }
    ListNode* revll(ListNode* head){
        ListNode* prev=NULL,*curr=head;
        while(curr){
            ListNode* next=curr->next;
            curr->next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    bool isPalindrome(ListNode* head) {
        if(head->next==NULL) return 1;
        ListNode* mid=getmid(head);
        ListNode* rev=revll(mid->next);
        mid->next=rev;
        ListNode *ptr1=head,* ptr2=mid->next;
        while(ptr2){
            if(ptr1->val!=ptr2->val) return 0;
            ptr1=ptr1->next;
            ptr2=ptr2->next;
        }
        return 1;
    }
};