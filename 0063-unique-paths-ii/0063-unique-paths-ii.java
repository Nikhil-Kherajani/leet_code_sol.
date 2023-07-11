class Solution {
    private int[][] v;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m == 0 || n == 0){
            return 0;
        }
        v = new int[m][n];
        return dfs(0,0,m,n,obstacleGrid);
    }
    
    public int dfs(int i, int j, int m, int n, int[][] obstacleGrid){
        if(i>=m || j>=n || obstacleGrid[i][j] == 1){
            return 0;
        }
        if(v[i][j] != 0){
            return v[i][j];
        }
        else if(i == m-1 && j==n-1){
            return 1;
        }
        int paths = 0;
        paths += dfs(i,j+1,m,n,obstacleGrid);
        paths += dfs(i+1,j,m,n,obstacleGrid);
        return v[i][j] = paths;

        
    }
}






    
    