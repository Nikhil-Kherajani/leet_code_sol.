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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean end = false;
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                TreeNode temp = q.remove();
                // System.out.println(temp.val);
                
                    if(!end && temp.left != null){
                        q.add(temp.left );
                    }
                    else if(!end && temp.left == null){
                        end = true; 
                    }
                    else if(end && temp.left != null){
                        return false;
                    }
                    
                
                
                    if(!end && temp.right != null){
                        q.add(temp.right );
                    }
                    else if(!end && temp.right == null){
                        end = true; 
                    }
                    else if(end && temp.right != null){
                        return false;
                    }
                
                // if(end && temp.left){
                //     return false;
                // }
                
                
            } 
        }
        return true;
    }
}









