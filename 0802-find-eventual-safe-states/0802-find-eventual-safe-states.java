class Solution {
     int n;
    private int[] ans;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        n = graph.length; 
        ans = new int[n];
        ArrayList<Integer>[] map = new ArrayList[n];

        for(int i = 0 ; i < n ; i++){
            map[i] = new ArrayList<Integer>();
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < graph[i].length; j++){
                map[i].add(graph[i][j]);
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(ans[i] == 0){
                if(dfs(map,i, new boolean[n])){
                    ans[i] = 2;
                }
                else{
                    ans[i] = 1;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < n ;i++ ){
            if(ans[i] == 2){
                result.add(i);
            }
        }
        return result;
        
    } 
    
    public boolean dfs(ArrayList<Integer>[] map , int i, boolean[] v){
        boolean sol = true;
        
        if(v[i]){
            return false;
        }
        if(ans[i] == 2){
            
            return true;
        }
        else if(ans[i] ==1){
            return false;
        }
        v[i] = true;
        for(int j : map[i]){
            sol = dfs(map, j , v);
            if(!sol){
                break;
            }
        }
        v[i] = false;
        if(sol){
            ans[i] = 2;
        }
        else if(!sol){
            ans[i] = 1;
        }
        return sol;
        
    }
        
        
              
        
        
        
}