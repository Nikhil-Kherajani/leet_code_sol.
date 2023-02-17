class Solution {
    TreeNode previous = null;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return min;
    }
    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(previous!=null){
            min = Math.min(min, root.val-previous.val);
        }
        previous = root;
        inOrder(root.right);
    }
}