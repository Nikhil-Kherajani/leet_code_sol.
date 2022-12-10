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
    ArrayList<Long> list=new ArrayList<>();
    public int maxProduct(TreeNode root) 
    {
        long total=total(root);
        long max=0,mod=1000000007;
        for(int i=0;i<list.size();i++)
        {
            max=Math.max(max,(total-list.get(i))*list.get(i));
        }
        return (int)(max%mod);
    }
    public long total(TreeNode node)
    {
        if(node==null) return 0;
        long left=total(node.left);
        long right=total(node.right);
        long subsum=left+right+node.val;
        list.add(subsum);
        return subsum;
    }
}