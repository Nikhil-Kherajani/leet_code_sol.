class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new LinkedList();
        List<Integer> current = new ArrayList();
        current.add(0);
        dfs(0,current,graph,graph.length-1,ans);
        return ans; 
    }
    private void dfs(int src, List<Integer> current, int graph[][], int dest, List<List<Integer>> ans){
        if(src == dest){
            ans.add(new ArrayList(current));
            return;
        }
        for(int n : graph[src]){
            current.add(n);
            dfs(n,current,graph,dest,ans);
            current.remove(current.size()-1);
        }
    }
}
