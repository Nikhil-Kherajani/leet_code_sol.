class Solution {
    private boolean[] visited ;
    private int count = 0;
    public long countPairs(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        visited = new boolean[n];
        int nc = n;
        long ans = 0;
        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int[] val : edges){
            graph[val[0]].add(val[1]);
            graph[val[1]].add(val[0]);
        }

        for(int i = 0 ; i < n ; i++){
            dfs(i, graph);
            // System.out.println(nc + " " + count + " " + ans);
            ans += ((long)count * (nc - count));
            nc -= count;
            count = 0;
            if(nc == 0){
                break;
            }
        }
        return ans;

        
    }
    
    public void dfs(int i, ArrayList<Integer>[] graph){
        if(visited[i]){
            return;
        }
        visited[i] = true;
        count++;
        
        for(int j = 0 ; j < graph[i].size() ; j++){
            dfs(graph[i].get(j) , graph);
        }
    }
}