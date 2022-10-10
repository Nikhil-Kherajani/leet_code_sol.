class Solution {
    public int sumRootToLeaf(TreeNode root) {
        String s = "";
        int sum = 0;
        return  DFS(root, s, sum);
    }

    private int DFS(TreeNode root, String s, int sum) {
        if(root.left == null && root.right == null){
            sum += Integer.parseInt(s+root.val, 2);
            return sum;
        }
        if (root.left != null)
            sum = DFS(root.left, s+root.val, sum);
        if(root.right != null)
            sum = DFS(root.right, s+root.val, sum);
        return sum;
    }
}