
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode copyHead = head;
        ListNode start = head;
        int i = 1;
        while (i < k) {
            i++;
            start = start.next;
        }
        ListNode temp = start.next;
        start.next = null;

        head = reverse(head);
        copyHead.next = temp;
        i = 1;
        ListNode prev = copyHead;
        ListNode next;
        start = temp;
        while (true) {
            while (temp != null && i < k) {
                temp = temp.next;
                i++;
            }
            if (i == k && temp != null) {
                next = temp.next;
                temp.next = null;
                temp = reverse(start);
                prev.next = temp;
                start.next = next;
                prev = start;
                temp = next;
                start = next;
                i = 1;
            } else {
                break;
            }

        }
        return head;

    }

    ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
}
