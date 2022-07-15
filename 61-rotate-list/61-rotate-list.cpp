/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    // Runtime: O(n)  Space: O(1)    
    ListNode* rotateRight(ListNode* head, int k) {
        // Check if head is nullptr or no rotation is applied
        if(head == nullptr || k == 0)
            return head;
        
        // Store curr & prev node pointers
        ListNode *curr = head, *prev;
        
        // Store length
        int length = 0;
        
        // Find length of list
        while(curr != nullptr) {
            length++;
            prev = curr;
            curr = curr->next;
        }
        
        // Perform modulus operation to no apply unnecessary rotations
        k %= length;
        
        // Check if no rotations need to be applied once again
        if(k == 0)
            return head;

        // Wrap last node in list back to head
        prev->next = head;
        
        // Reset curr pointer to head
        curr = head;
            
        // Advance curr pointer to new last node based on k-rotations
        for(int i = 1; i < (length - k); i++)
            curr = curr->next;

        // Set new head of list
        head = curr->next;
        
        // Set next node of previous node to nullptr
        curr->next = nullptr;
        
        return head;
    }
};