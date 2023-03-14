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
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        traversal(root , "");
        
        return sum;
    }
    
    public void traversal(TreeNode root , String path){
       
        boolean l = false , r = false;
        
        path += root.val + "";
        if(root.left != null){
            traversal(root.left , path);
            l = true;
        }
        if(root.right != null){    
            traversal(root.right , path);
            r = true;
        }
        
        if(!l & !r){
             sum += Integer.parseInt(path);
        }
    }
}






