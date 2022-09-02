class Solution {
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        TreeNode dhiraj = new TreeNode(0);
        TreeNode curr = dhiraj; //curr is pointing to dhiraj
        for(int x: ans){
            curr.right = new TreeNode(x);
            curr = curr.right;
        }
        return dhiraj.right;
    }
    
    static void inorder(TreeNode root, ArrayList<Integer> ans){
        if(root == null) 
            return ;
        
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}
