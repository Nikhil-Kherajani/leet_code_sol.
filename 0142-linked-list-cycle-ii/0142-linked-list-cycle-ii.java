/*
  Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 */

class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head.next;
        ListNode fast ;
        if(head.next != null)
            fast = head.next.next;
        else{
            return null;
        } 
        while (slow != fast) {
            if (fast == null || fast.next == null || slow == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
           
        }
        while(head != slow){
            head = head.next;
            slow = slow.next;
        }

        return head;

    }
}