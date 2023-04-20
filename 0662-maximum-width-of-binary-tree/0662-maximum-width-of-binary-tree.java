class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;
        
        int result = Integer.MIN_VALUE;

        ArrayDeque<Pair<TreeNode, Integer>> q = new ArrayDeque<Pair<TreeNode, Integer>>();
        q.add(new Pair<>(root, 0));

        while(!q.isEmpty()) {

            int size = q.size();
            result = Math.max(result, (q.getLast().getValue() - q.getFirst().getValue() + 1));

            for(int i = 0; i < size; i++) {

                Pair<TreeNode, Integer> pair = q.poll();
                TreeNode item = pair.getKey();
                int index = pair.getValue();

                if(item.left != null) q.add(new Pair<>(item.left, 2*index+1));
                if(item.right != null) q.add(new Pair<>(item.right, 2*index+2));
            }
        }

        return result;
    }
}