class Solution {
    int count = 0;
    
    Pair<Integer, Integer> postOrder(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        
        // First iterate over left and right subtrees.
        Pair<Integer, Integer> left = postOrder(root.left);
        Pair<Integer, Integer> right = postOrder(root.right);
        
        int nodeSum = left.getKey() + right.getKey() + root.val;
        int nodeCount = left.getValue() + right.getValue() + 1;

        // Check if the average of the subtree is equal to the node value.
        if (root.val == nodeSum / (nodeCount)) {
            count++;
        }
        
        // Return the sum of nodes and the count in the subtree.
        return new Pair(nodeSum, nodeCount);
    }
    
    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return count;
    }
}