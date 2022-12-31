class Solution {
    public int uniquePathsIII(int[][] grid) {

        int total = 0;
        int x = 0;
        int y = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 1) {
                    total++;
                }
                if(grid[i][j] == 1){
                    x = i;
                    y = j;
                }
            }
        }
        // System.out.println(total);
        int[][] visited = new int[grid.length][grid[0].length];
        paths(grid, x, y, total, 0, visited);
        return ans;
    }

    public int ans = 0;

    public void paths(int[][] grid, int i, int j, int t, int c, int[][] visited) {
        // System.out.println(c + " val = ");

        if ( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] != 0 ) {
            return;
        }
        if (grid[i][j] == 2) {
            if (c == t) {
                ans++;
            } else {
                return;
            }
        }
        visited[i][j] = 1;
        
        if (i-1>=0 && visited[i - 1][j] == 0 && grid[i - 1][j] != -1) {
            paths(grid, i - 1, j, t, c + 1, visited);
            visited[i - 1][j] = 0;
        }
        if (j+1 <grid[0].length && visited[i][j + 1] == 0 && grid[i][j + 1] != -1) {
            paths(grid, i, j + 1, t, c + 1, visited);
            visited[i][j + 1] = 0;
        }
        if (i+1 < grid.length && visited[i + 1][j] == 0 && grid[i + 1][j] != -1) {
            paths(grid, i + 1, j, t, c + 1, visited);
            visited[i+1][j] = 0;
        }
        if (j-1 >= 0 && visited[i][j - 1] == 0 && grid[i][j - 1] != -1) {
            paths(grid, i, j - 1, t, c + 1, visited);
            visited[i][j - 1] = 0;
        }
    }
}