class Solution {
    public int[] findMode(TreeNode root) {
        int maxStreak = 0;
        int currStreak = 0;
        int currNum = 0;
        List<Integer> ans = new ArrayList();
        
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                // Find the friend
                TreeNode friend = curr.left;
                while (friend.right != null) {
                    friend = friend.right;
                }
                
                friend.right = curr;
                
                // Delete the edge after using it
                TreeNode left = curr.left;
                curr.left = null;
                curr = left;
            } else {
                // Handle the current node
                int num = curr.val;
                if (num == currNum) {
                    currStreak++;
                } else {
                    currStreak = 1;
                    currNum = num;
                }

                if (currStreak > maxStreak) {
                    ans = new ArrayList();
                    maxStreak = currStreak;
                }

                if (currStreak == maxStreak) {
                    ans.add(num);
                }
                
                curr = curr.right;
            }
        }
        
        
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        
        return result;
    }
}