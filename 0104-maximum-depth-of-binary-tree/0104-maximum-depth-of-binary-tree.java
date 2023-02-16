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
    private int maxd;
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root , 1);
        return maxd;
    }
    public void dfs(TreeNode root, int step){
        maxd = Math.max(maxd , step);
        if(root.left != null){
            dfs(root.left , step + 1);
        }
        if(root.right != null){
            dfs(root.right , step + 1); 
        }
    }
}