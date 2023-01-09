class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        if (size == 1 && n == 1) {
            head = null;
            return head;
        }
        if (size == n) {
            head = head.next;
            return head;
        }
        temp = head;
        for (int i = 1; i < size - n && temp != null; i++) {
            temp = temp.next;
        }
        if (temp != null && temp.next != null)
            temp.next = temp.next.next != null ? temp.next.next : null;
        return head;
    }
}