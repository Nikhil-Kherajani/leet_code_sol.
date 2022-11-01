class Solution {
    int m = 0;
    int n = 0;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int curretArea = island(grid, i, j);
                    max = Math.max(max, curretArea);
                } 
            }
        }
        return max;
    }
    
    int cnt = 0;
    public int island(int[][] grid, int i, int j){
        //When Index is out of bound
        if(i < 0 || i >= m || j < 0 || j >= n){            
            return 0;
        }
        
        //If water found then return
        if(grid[i][j] == 0){
            return 0;
        }
        
        //If not water, then count it's length and set this cell = 0
        if(grid[i][j] == 1){
            grid[i][j] = 0;
            cnt = 1;
        }
        
        //Recursive call for 4 diagnal cell
        cnt+=island(grid, i, j+1);
        cnt+=island(grid, i, j-1);
        cnt+=island(grid, i+1, j);
        cnt+=island(grid, i-1, j);
        
        return cnt;
    }
}