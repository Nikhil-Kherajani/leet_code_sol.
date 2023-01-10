class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        else {
            if (isSameTree(p.left, q.left))
                return isSameTree(p.right, q.right);
            else {
                return false;
            }
        }
    }
}