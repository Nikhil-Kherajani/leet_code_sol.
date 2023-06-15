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
    public int maxLevelSum(TreeNode root) {
        int max = root.val , level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 1;
        int l = 0;
        while(q.size() > 0){
            int sum = 0;
            l++;
            while(size > 0){
                TreeNode temp = q.poll();
                // System.out.println(l);
                sum += temp.val;
                if(temp.left != null)
                q.add(temp.left);
                if(temp.right != null)
                q.add(temp.right);
                size--;
            }
            if(sum > max){
                max = sum;
                level = l;
            }
            size = q.size();
        }
        
        return level;
        
    }
}


















