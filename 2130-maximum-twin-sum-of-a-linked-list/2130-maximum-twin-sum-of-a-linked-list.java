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
    public ListNode rev(ListNode head) {
    ListNode prev = null;
    ListNode current = head; 
    
    while (current != null) {
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    
    return prev;
}

    public int pairSum(ListNode head) {
        
        int max = Integer.MIN_VALUE;
        
        ListNode s = head;
        ListNode f = head;
        while(f != null){
            s = s.next;
            f = f.next.next;
        }
        
        s = rev(s);
        while(s != null){
            max = Math.max(max , s.val + head.val);
            s = s.next;
            head = head.next;
        }
        
        return max;
    }
    
    
    
    
    
    
    
    
}