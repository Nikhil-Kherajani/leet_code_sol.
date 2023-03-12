class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode first = lists[0];
        for (int i = 1; i < lists.length; i++) {
            first = mergeTwoLists(first, lists[i]);
        }
        return first;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode merged = null;
        if (l1.val <= l2.val) {
            merged = l1;
            merged.next = mergeTwoLists(l1.next, l2);
        } else {
            merged = l2;
            merged.next = mergeTwoLists(l1, l2.next);
        }
        return merged;
    }

}