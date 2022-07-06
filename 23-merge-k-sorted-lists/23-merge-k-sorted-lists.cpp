class Solution {
public:
    ListNode* gen(ListNode* l1,ListNode* l2){
        ListNode* dum = new ListNode();
        ListNode* p=l1;
        ListNode* q=l2;
        ListNode* t=dum;
        while(p || q){
            if(p==NULL && q!=NULL){
                t->next=q;
                q=q->next;
                t=t->next;
            }
            else if(p!=NULL && q==NULL){
                t->next=p;
                p=p->next;
                t=t->next;
            }
            else if((p->val)<(q->val)){
                t->next=p;
                p=p->next;
                t=t->next;
            }
            else{
                t->next=q;
                q=q->next;
                t=t->next;
            }
        }
        return dum->next;
    }
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.size()==1) return lists[0];
            
        if(lists.size()==0) return NULL;
        for(int i=1;i<lists.size();i++){
            lists[0]=gen(lists[0],lists[i]);
        }
        return lists[0];
    }
};