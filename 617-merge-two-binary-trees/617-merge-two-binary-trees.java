class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        else if(root2==null) return root1;
        solve(root1,root2,null,null,-1);
        return root1;
    }
    public static void solve(TreeNode root1,TreeNode root2,TreeNode parent1,TreeNode parent2, int side){
        if(root1==null && root2==null) return;
        else if(root1==null){
            if(side==0) parent1.left=root2;
            else parent1.right=root2;
        }
        else if(root2!=null){
            root1.val+=root2.val;
            solve(root1.left,root2.left,root1,root2,0);
            solve(root1.right,root2.right,root1,root2,1);
        }
    }
}