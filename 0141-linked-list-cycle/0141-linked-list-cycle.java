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
        int count = 0;
        while (head != null) {
            count++;
            if (count > 10000) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
