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
     int sum = 0;
    
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if(root == null){
            return 0 ;
        }
        if(root.val <= high &&  root.val >= low){
            sum = sum + root.val;
        }
        rangeSumBST2(root.left , low , high);
        rangeSumBST2(root.right , low , high);
        
        return 0;
    } 
    
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        rangeSumBST2(root , low , high);
        return sum;
    }
}