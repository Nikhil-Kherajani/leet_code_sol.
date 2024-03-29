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
     public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        
        ListNode oddPointer = head;
        ListNode evenPointer = head.next;
        ListNode evenStartPointer = head.next;
        
        while(oddPointer != null && evenPointer != null && evenPointer.next != null) {
            oddPointer.next = evenPointer.next;
            evenPointer.next = oddPointer.next.next;
            oddPointer.next.next = evenStartPointer;
            oddPointer = oddPointer.next;
            evenPointer = evenPointer.next;
        }
        return head;
    }
}
