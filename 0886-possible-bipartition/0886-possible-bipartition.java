class Solution {
    int n;
    Map<Integer,List<Integer>> graph;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (dislikes == null || dislikes.length == 0)
            return true;

        graph = new HashMap<>();
        for(int[] dislik: dislikes){
            int hater = dislik[0];
            int hatee = dislik[1];
            graph.putIfAbsent(hatee, new ArrayList<>());
            graph.putIfAbsent(hater, new ArrayList<>());
            graph.get(hater).add(hatee);
            graph.get(hatee).add(hater);
        }

        int[] color = new int[1+n];
        for(int i = 1; i <= n; i++){
            if (color[i] == 0){
                if (!dfs(i, color, color[i]))
                    return false;
            }
        }
        return true;
    }
    private boolean dfs(int u, int[] color, int curColor){
        if (curColor == 0){
            color[u] = 1;
        } else {
            color[u] = curColor;
        }

        if (!graph.containsKey(u))
            return true;
        for(int adjVert: graph.get(u)){
            if (color[adjVert] == color[u]){
                return false;
            }
            if (color[adjVert] != 0)
                continue;
            if (!dfs(adjVert, color, -1*color[u]))
                return false;
        }
        return true; 
    }

}