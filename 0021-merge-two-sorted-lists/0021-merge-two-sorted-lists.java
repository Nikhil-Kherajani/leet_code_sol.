class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) {
            return list2;
        } else if (list1 != null && list2 == null) {
            return list1;
        } else if (list1 == null && list2 == null) {
            return null;
        }

        ListNode pointer1 = list1, pointer2 = list2;
        while (pointer1 != null && pointer2 != null) {
            if (pointer1.val <= pointer2.val) {
                if (pointer1.next != null && pointer1.next.val < pointer2.val) {
                    pointer1 = pointer1.next;
                    continue;
                }
                ListNode temp = pointer1.next;
                ListNode temp2 = pointer2.next;
                pointer1.next = pointer2;
                pointer2.next = temp;
                pointer2 = temp2;
                // pointer1 = temp;

            } else {
                if (pointer2.next != null && pointer2.next.val < pointer1.val) {
                    pointer2 = pointer2.next;
                    continue;
                }
                ListNode temp = pointer2.next;
                ListNode temp2 = pointer1.next;
                pointer2.next = pointer1;
                pointer1.next = temp;
                pointer1 = temp2;
                // pointer2= temp;
            }
        }
        // if(pointer1.next != null){
        // while (pointer1.next != null) {
        // pointer2.next = pointer1;
        // pointer1 = pointer1.next;
        // }}
        // else{
        // while (pointer2.next != null) {
        // pointer1.next = pointer2;
        // pointer2 = pointer2.next;
        // }}
        return list1.val <= list2.val ? list1 : list2;

    }
}