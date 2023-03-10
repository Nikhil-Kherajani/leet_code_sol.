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

    private ArrayList<Integer> a = new ArrayList<>(); 
    private int size = 0;
    public Solution(ListNode head) {
        while(head != null){
            a.add(head.val);
            head = head.next;
        }
        size = a.size();
    }
    
    public int getRandom() {
        double ran = Math.random();
        // System.out.println((int)());
        return a.get((int)(ran*10000 % size));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */