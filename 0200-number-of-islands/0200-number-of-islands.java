import java.util.*;

class Solution {

    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        int ans = 0;
        int i = grid.length;
        int j = grid[0].length;
        visited = new boolean[i][j];
        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                if (!visited[m][n] && grid[m][n] == '1') {
                    ans++;
                    islandCheck(grid, m, n, i, j);
                }
            }
        }

        return ans;
    }

    public void islandCheck(char[][] grid, int i, int j, int m, int n) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        if (i > 0 && grid[i - 1][j] == '1')
            islandCheck(grid, i - 1, j, m, n);
        if (i < m - 1 && grid[i + 1][j] == '1')
            islandCheck(grid, i + 1, j, m, n);
        if (j > 0 && grid[i][j - 1] == '1')
            islandCheck(grid, i, j - 1, m, n);
        if (j < n - 1 && grid[i][j + 1] == '1')
            islandCheck(grid, i, j + 1, m, n);

    }
}