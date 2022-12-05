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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        
        int count = 1;
        while (temp.next != null) {
            count++;
            temp = temp.next;

        }
        
        temp = head;
        for (int i = 0; i < count / 2; i++) {
            temp = temp.next;
        }
        
        return temp;
    }
}