class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap();
        
        for (int[] edge : adjacentPairs) {
            int x = edge[0];
            int y = edge[1];
            
            if (!graph.containsKey(x)) {
                graph.put(x, new ArrayList());
            }
            
            if (!graph.containsKey(y)) {
                graph.put(y, new ArrayList());
            }
            
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        int root = 0;
        for (int num : graph.keySet()) {
            if (graph.get(num).size() == 1) {
                root = num;
                break;
            }
        }
        
        int curr = root;
        int[] ans = new int[graph.size()];
        ans[0] = root;
        int i = 1;
        int prev = Integer.MAX_VALUE;
        
        while (i < graph.size()) {
            for (int neighbor : graph.get(curr)) {
                if (neighbor != prev) {
                    ans[i] = neighbor;
                    i++;
                    prev = curr;
                    curr = neighbor;
                    break;
                }
            }
        }

        return ans;
    }
}