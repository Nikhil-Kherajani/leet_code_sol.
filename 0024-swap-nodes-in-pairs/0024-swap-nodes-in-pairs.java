
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = head.next;
        ListNode previous = null;
        while (head != null && head.next != null) {
            ListNode first = head;
            head = head.next;
            ListNode next = head.next;
            head.next = first;
            first.next = next;
            // // if (first != null && head != null && next != null)
            // System.out.println("first: " + first.val + " head = " + head.val + " next = "
            // + next);
            
            if (previous == null) {
                previous = first;
            } else {
                previous.next = head;
                previous = first;
            }
            head = next;
        }
        return start;

    }
}