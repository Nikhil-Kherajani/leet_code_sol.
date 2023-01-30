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
    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ListNode temp = head;
        while (temp != null) {
            a.add(temp.val);
            temp = temp.next;
        }
        for (int i = 0; i < a.size(); i += k) {
            // System.out.println(i + " " + i+k);
            if(i + k <= a.size())
            reverse(a.subList(i, i + k));
        }
        temp = head;
        for (int i = 0; i < a.size(); i++) {
            temp.val = a.get(i);
            temp = temp.next;
        }
        return head;
    }

    public void reverse(List<Integer> a) {
        int l = 0;
        int r = a.size()-1;
        while (l < r) {
            int temp = a.get(l);
            a.set(l, a.get(r));
            a.set(r, temp);
            l++;
            r--;
        }
    }
}