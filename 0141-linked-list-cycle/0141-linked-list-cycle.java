/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode i = head, j = head;
        while (i != null && j != null && j.next != null && j.next.next != null) {
            i = i.next;
            j = j.next.next;
            if (i == j) {
                return true;
            }
        }
        return false;
    }
}
