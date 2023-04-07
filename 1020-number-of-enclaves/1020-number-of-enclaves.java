class Solution {
    private boolean[][] visited;
    private boolean end;
    private int temp = 0;
    public int numEnclaves(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int ans = 0;
        visited = new boolean[m][n];
        
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                end = false;
                temp = 0;
                if(!visited[i][j] && grid[i][j] == 1){
                    dfs(grid, m , n , i , j);
                    if(!end){
                        // System.out.println(i + "" + j);
                    ans+= temp;
                }
                }       
                
            }
        }
                    return ans;
    }
    public void dfs(int[][] grid , int m , int n , int i , int j){
        
        if(visited[i][j]){
            return ;
        }
        else{
            visited[i][j] = true;
        }
        
        if(i+1 >= m || j+1 >= n || i-1 < 0 || j-1 < 0){
            end = true;
            return;
        }
        temp++;
        if(grid[i + 1][j] == 1 ){
            dfs(grid, m , n , i+1 , j);
        }
        if(grid[i-1][j] == 1 ){
            dfs(grid, m , n , i-1 , j);
        }
        if(grid[i][j+1] == 1 ){
            dfs(grid, m , n , i , j+1);
        }
        if(grid[i][j-1] == 1 ){
            dfs(grid, m , n , i , j-1);
        }
       
    }
}

