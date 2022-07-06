class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if(list1 == nullptr)
            return list2;
        if(list2 == nullptr)
            return list1;
        ListNode* head = new ListNode(0);
        ListNode* prev = head;
        
        while(list1 &&  list2 ){
            if(list1->val < list2->val){
                head->next = new ListNode(list1->val);
                list1 = list1->next;
            }else{
                head->next = new ListNode(list2->val);
                list2 = list2->next;
            }
            head = head->next;
        }
        
        while(list1 != nullptr){
            head->next = new ListNode(list1->val);
            list1 = list1->next;
            head = head->next;
        }
        
        while(list2 != nullptr){
            head->next = new ListNode(list2->val);
            list2 = list2->next;
            head = head->next;
        }
        
        return prev->next;
    }
};