import java.util.*;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j < n - 1 && i < m - 1) {
                   
                    grid[i][j] += Math.min(grid[i][j + 1], grid[i + 1][j]);
                } else {
                    if (j < n - 1) {
                        
                        grid[i][j] += grid[i][j + 1];
                    }
                    if (i < m - 1) {
                        
                        grid[i][j] += grid[i + 1][j];
                    }
                }
            }
        }

        return grid[0][0];
    }
}