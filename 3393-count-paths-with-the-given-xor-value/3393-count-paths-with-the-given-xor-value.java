class Solution {
    public int countPathsWithXorValue(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = 1000000007;

        // dp[i][j][xor] stores the number of paths from (0, 0) to (i, j) with xor value equal to xor
        int[][][] dp = new int[m][n][16];

        // Base case: There is 1 path from (0, 0) to (0, 0) with xor value equal to grid[0][0]
        dp[0][0][grid[0][0]] = 1;

        // Iterate over the grid and fill the dp array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int xor = 0; xor < 16; xor++) {
                    // If we can reach (i, j) from (i - 1, j)
                    if (i > 0) {
                        dp[i][j][xor ^ grid[i][j]] = (dp[i][j][xor ^ grid[i][j]] + dp[i - 1][j][xor]) % mod;
                    }
                    // If we can reach (i, j) from (i, j - 1)
                    if (j > 0) {
                        dp[i][j][xor ^ grid[i][j]] = (dp[i][j][xor ^ grid[i][j]] + dp[i][j - 1][xor]) % mod;
                    }
                }
            }
        }

        // Return the number of paths from (0, 0) to (m - 1, n - 1) with xor value equal to k
        return dp[m - 1][n - 1][k];
    }
}