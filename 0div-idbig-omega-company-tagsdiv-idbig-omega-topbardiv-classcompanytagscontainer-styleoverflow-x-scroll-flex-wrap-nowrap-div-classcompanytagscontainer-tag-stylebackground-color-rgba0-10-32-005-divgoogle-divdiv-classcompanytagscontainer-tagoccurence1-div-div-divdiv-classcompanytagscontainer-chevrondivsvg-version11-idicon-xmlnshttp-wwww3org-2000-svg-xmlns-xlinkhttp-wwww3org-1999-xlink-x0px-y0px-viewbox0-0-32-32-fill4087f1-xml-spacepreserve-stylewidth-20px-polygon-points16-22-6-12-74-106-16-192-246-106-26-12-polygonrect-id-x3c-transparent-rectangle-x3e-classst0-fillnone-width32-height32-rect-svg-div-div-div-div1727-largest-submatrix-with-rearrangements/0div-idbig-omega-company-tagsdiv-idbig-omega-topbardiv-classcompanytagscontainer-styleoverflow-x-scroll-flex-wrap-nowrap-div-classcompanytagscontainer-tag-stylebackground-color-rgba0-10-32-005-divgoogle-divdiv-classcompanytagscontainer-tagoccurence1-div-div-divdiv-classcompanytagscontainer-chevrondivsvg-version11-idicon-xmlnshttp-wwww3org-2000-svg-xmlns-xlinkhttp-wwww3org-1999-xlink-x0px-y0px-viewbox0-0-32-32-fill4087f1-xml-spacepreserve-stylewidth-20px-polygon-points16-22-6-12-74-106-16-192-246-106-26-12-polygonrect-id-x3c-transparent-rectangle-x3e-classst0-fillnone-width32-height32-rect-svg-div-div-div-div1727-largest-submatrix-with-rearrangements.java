class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Pair<Integer,Integer>> prevHeights = new ArrayList();
        int ans = 0;
        
        for (int row = 0; row < m; row++) {
            List<Pair<Integer,Integer>> heights = new ArrayList();
            boolean[] seen = new boolean[n];
            
            for (Pair<Integer, Integer> pair : prevHeights) {
                int height = pair.getKey();
                int col = pair.getValue();
                if (matrix[row][col] == 1) {
                    heights.add(new Pair(height + 1, col));
                    seen[col] = true;
                }
            }
            
            for (int col = 0; col < n; col++) {
                if (seen[col] == false && matrix[row][col] == 1) {
                    heights.add(new Pair(1, col));
                }
            }
            
            for (int i = 0; i < heights.size(); i++) {
                ans = Math.max(ans, heights.get(i).getKey() * (i + 1));
            }

            prevHeights = heights;
        }
        
        return ans;
    }
}

