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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int[] arr;
    private int size = 0;
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        arr = new int[size];
        temp = head;
        int i = 0;
        while(temp != null){
            arr[i++] = temp.val;
            temp = temp.next;
        }
       
        
        return createBST(0 , size - 1);
        
    }
    
    
    public TreeNode createBST(int s , int e ){
        if(s > e){
            return null;
        }
        int m = (s + e)/2 ;
        TreeNode root = new TreeNode();
        root.val = arr[m];
        root.left = createBST(s , m - 1);
        root.right = createBST(m + 1 , e);
        return root;
    }
}














