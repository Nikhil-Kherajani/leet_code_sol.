class Solution {
    ArrayList<Integer> nodes = new ArrayList<Integer>();
    public Solution(ListNode head) {
        while (head != null) {
            nodes.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        int i = (int)(Math.random() * this.nodes.size());
        return this.nodes.get(i);
    }
}