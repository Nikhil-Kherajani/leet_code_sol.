class Solution {
    public int countPathsWithXorValue(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1000000007;
        
        // Initialize the DP table
        int[][][] dp = new int[m][n][16];
        dp[0][0][grid[0][0]] = 1;
        
        // Iterate through each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int x = 0; x < 16; x++) {
                    if (dp[i][j][x] > 0) {
                        // Move right
                        if (j + 1 < n) {
                            int newX = x ^ grid[i][j + 1];
                            dp[i][j + 1][newX] = (dp[i][j + 1][newX] + dp[i][j][x]) % MOD;
                        }
                        // Move down
                        if (i + 1 < m) {
                            int newX = x ^ grid[i + 1][j];
                            dp[i + 1][j][newX] = (dp[i + 1][j][newX] + dp[i][j][x]) % MOD;
                        }
                    }
                }
            }
        }
        
        // The result is the number of ways to reach (m-1, n-1) with XOR value k
        return dp[m - 1][n - 1][k];
    }
}