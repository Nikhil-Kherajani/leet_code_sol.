class Solution {
    
        
    private long ans = 0;
    private boolean[] visited;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            graph[roads[i][0]].add(roads[i][1]);
            graph[roads[i][1]].add(roads[i][0]);
        }
        visited = new boolean[n];
        dfs(graph, 0, seats);
        return ans;

    }

    public double dfs(ArrayList<Integer>[] graph, int cur, int s) {
        visited[cur] = true;
        int nno = 1;
        for (int child : graph[cur]) {
            if (!visited[child])
                nno += dfs(graph, child, s);
        }
        double result = (double) nno / s;
        if(cur != 0)
        ans += (int) Math.ceil(result);
        // System.out.println((int) Math.ceil(result) + " " + cur);

        return nno;
    }
}