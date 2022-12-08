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
    
    public ArrayList<Integer> l1 = new ArrayList<>();
    public ArrayList<Integer> l2 = new ArrayList<>();
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        findLeaves(root1);
        findLeaves2(root2);
       
        if(l1.size() != l2.size()){
            return false;
        }
        
        for(int i = 0 ; i < l1.size() ; i++){
            if(l1.get(i) != l2.get(i)){
                return false;
            }
        }
        return true;
    }
    

    
    public void findLeaves(TreeNode root){
        if(root.left != null){
            findLeaves(root.left);
        }
        if(root.right != null){
            findLeaves(root.right);
        }
        if(root.left == null && root.right == null){
            l1.add(root.val);
        }
    }
    
    public void findLeaves2(TreeNode root){
        if(root.left != null){
            findLeaves2(root.left);
        }
        if(root.right != null){
            findLeaves2(root.right);
        }
        if(root.left == null && root.right == null){
            l2.add(root.val);
        }
    }
    
    
}