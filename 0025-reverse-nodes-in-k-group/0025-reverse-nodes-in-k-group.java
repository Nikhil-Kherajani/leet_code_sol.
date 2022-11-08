class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // base case
        if(k == 1) return head;
        ListNode currNode = head;
        for(int i = 0 ; i < k ; i ++) {
           if(head != null) {
                head = head.next;
           }else {
               // last group found
               return currNode;
           }
        }
        // recursion
        ListNode nextGroup = reverseKGroup(head,k);
        // back tracking reverse curr group
        ListNode currStart = currNode;
        ListNode tempPre = currNode;
        ListNode tempNext = null;
        for(int i = 0 ; i < k ; i ++) {
            tempNext = currNode.next;
            currNode.next = tempPre;
            tempPre = currNode;
            currNode = tempNext;
        }
        // connect curr to next group
        currStart.next = nextGroup;
		// return first node of curr group and keep back tracking until stack is empty
        return tempPre;
    }
}