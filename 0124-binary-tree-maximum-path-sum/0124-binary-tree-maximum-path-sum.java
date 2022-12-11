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
    public int maxPathSum(TreeNode root) {
        findMaxSum(root);
        return Res;

    }
    
    public int Res = Integer.MIN_VALUE;

    

    // This function returns overall maximum path sum in
    // 'res' And returns max path sum going through root.
    public int findMaxUtil(TreeNode root) {

        // Base Case
        if (root == null)
            return 0;

        // l and r store maximum path sum going through left
        // and right child of root respectively
        int l = findMaxUtil(root.left);
        int r = findMaxUtil(root.right);

        // Max path for parent call of root. This path must
        // include at-most one child of root
        int max_single = Math.max(
                Math.max(l, r) + root.val, root.val);

        // Max Top re Resents the sum when the Node under
        // consideration is the root of the maxsum path and
        // no ancestors of root are there in max sum path
        int max_top = Math.max(max_single, l + r + root.val);

        // Store the Maximum Result.
        Res = Math.max(Res, max_top);

        return max_single;
    }

    // int findMaxSum(TreeNode root) { return findMaxSum(root); }

    // Returns maximum path sum in tree with given root
    public void findMaxSum(TreeNode root) {

        // Initialize Result
        // int Res2 = Integer.MIN_VALUE;

        

        // Compute and return Result
        findMaxUtil(root);
        
    }

}