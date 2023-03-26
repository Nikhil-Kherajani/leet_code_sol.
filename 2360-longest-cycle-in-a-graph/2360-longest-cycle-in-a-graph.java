class Solution {
    private boolean[] visited ;
    private int ans = 0;
    private int finalans = -1;
    public int longestCycle(int[] edges) {
        final int n = edges.length;
        visited = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            dfs(i , edges); 
            ans = 0;

        }
        return finalans;
        
    }
    
    public int dfs(int i , int[] edges){
        int count = -1;
        if(visited[i]){
            ans++;
            return i;
        }
        visited[i] = true;
        if(edges[i] != -1){
            count = dfs(edges[i] , edges);
        }
        if(count == i){
            finalans = Math.max(ans , finalans);
        }
        ans++;
        
        return count ;
        
    }
}