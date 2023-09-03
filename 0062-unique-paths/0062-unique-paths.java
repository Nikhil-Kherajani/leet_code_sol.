class Solution {
    private int[][] v;
    public int uniquePaths(int m, int n) {
        if(m == 1 && n == 1){
            return 1;
        }
        v = new int[m][n];
        return dfs(0,0,m,n);
    }
    
    public int dfs(int i, int j, int m, int n){
        if(i>=m || j>=n){
            return 0;
        }
        if(v[i][j] != 0){
            return v[i][j];
        }
        else if(i == m-1 && j==n-1){
            return 1;
        }
        int paths = 0;
        paths += dfs(i,j+1,m,n);
        paths += dfs(i+1,j,m,n);
        return v[i][j] = paths;

        
    }
}