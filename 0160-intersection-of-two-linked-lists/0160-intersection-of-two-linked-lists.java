/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ans = null;
        ListNode temp = headA;
        while (headA != null) {
            headA.val = -headA.val;
            headA = headA.next;
        }
        while (headB != null) {
            if (headB.val < 0) {
                headB.val = -headB.val;
                ans = headB;
                break;
            }
            headB = headB.next;
        }
        while (temp != null) {
            temp.val = -temp.val;
            temp = temp.next;
        }
        if(ans != null)
        ans.val = -ans.val ;

        return ans;
    }
}