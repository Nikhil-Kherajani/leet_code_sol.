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
        HashMap<ListNode, Integer> hm = new HashMap<>();
        // hm.put(head, 0);
        int i = 0 ;
        while(head != null){
            if(hm.containsKey(head)){
                return true;
            }
            hm.put(head, i);
            head = head.next;
        }
        return false;
    }
}