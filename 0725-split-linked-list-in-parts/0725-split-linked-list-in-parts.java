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
     public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int count = 0;
        ListNode cur = root;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        cur = root;
        int size = count / k, extra = count % k; 
        for (int i = 0; i < k && cur != null; i++) {
            res[i] = cur;
            //Find the tail
            for (int j = 0; j < size + (extra > 0 ? 1 : 0) - 1; j++) cur = cur.next;
            //Cut the connection 
            ListNode temp = cur.next;
            cur.next = null;
            cur = temp;
            //Update the remaining space for extra nodes
            extra--;
        }
        return res;
    }
}