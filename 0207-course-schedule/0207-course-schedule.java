class Solution {
    private int[] result ;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        result = new int[numCourses];
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int[] val : prerequisites){
            graph[val[0]].add(val[1]);
        }
        
        for(int i = 0 ; i < numCourses ; i++){
                // System.out.println(dfs(graph , i , new boolean[numCourses]));
                if(!dfs(graph , i , new boolean[numCourses])){
                    return false;
                }
            result[i] = 2;
        }
        return true;
        
    }
    
    public boolean dfs(ArrayList<Integer>[] graph , int i , boolean[] v){
        boolean ans = true;
        if(v[i]){
            return false;
        }
        if(result[i] == 1){
            return false;
        }
        else if(result[i] == 2){
            return true;
        }
        v[i] = true;
        
        
        
        for(int j= 0 ; j < graph[i].size() ; j++){
            if(!dfs(graph , graph[i].get(j) , v)){
                // System.out.println(j + " "+ graph);
                result[graph[i].get(j)] = 1;
                return false;
            }
        }
        v[i] = false;
        result[i] = 2;
        return true;
    }
}