class Solution {
    int max = Integer.MIN_VALUE;

    public int longestZigZag(TreeNode root) {
        solve(root, false);
        solve(root, true);
        return max;
    }

    public int solve(TreeNode node, boolean dir) {
        if (node == null) return -1;

        int right = ((node.right == null) ? -1 : solve(node.right, false)) + 1;
        
        int left = ((node.left == null) ? -1 : solve(node.left, true)) + 1;

   
        int childDirProfit = (dir) ? left : right;
        int parentDirProfit = (dir) ? right : left; 

        max = Math.max(max, Math.max(childDirProfit, parentDirProfit));
        
        return parentDirProfit;
    }
}