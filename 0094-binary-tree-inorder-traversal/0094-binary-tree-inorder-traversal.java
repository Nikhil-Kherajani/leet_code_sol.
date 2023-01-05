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
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> traversal = new ArrayList<>();
        if (root == null) {
            return traversal;
        }
        traversal(root, traversal);

        return traversal;
    }

    public List<Integer> traversal(TreeNode root, List<Integer> path) {
        if (root.left != null)
            traversal(root.left, path);
        path.add(root.val);
        if (root.right != null)
            traversal(root.right, path);
        return path;
    }
}