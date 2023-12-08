class Solution {
    StringBuilder s;
    public String tree2str(TreeNode root) {
        s=new StringBuilder();
        preorder(root);
        return s.toString().substring(1,s.length()-1);

    }
    public void preorder(TreeNode root){
        if(root!=null){
            s.append("(");

            s.append(root.val);
            if(root.left==null && root.right!=null){
                s.append("()");
            }
            preorder(root.left);
            preorder(root.right);

            s.append(")");
        }

    }
}