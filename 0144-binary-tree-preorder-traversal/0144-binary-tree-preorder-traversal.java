class Solution {
    List<Integer> path = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null)
            traversal(root);
        return path;

    }

    public void traversal(TreeNode root) {

        path.add(root.val);
        if (root.left != null)
            preorderTraversal(root.left);
        if (root.right != null)
            preorderTraversal(root.right);

    }

}