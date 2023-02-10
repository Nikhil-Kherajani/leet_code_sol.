import java.util.*;

class Solution {
    

    public int maxDistance(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int maxDistance = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.add(new Pair(i, j));
                }
            }
        }
        while (q.size() > 0) {
            int size = q.size();
            while (size > 0) {
                Pair top = q.poll();
                if (top.x - 1 >= 0 && !visited[top.x - 1][top.y]) {
                    q.add(new Pair(top.x - 1, top.y));
                    visited[top.x - 1][top.y] = true;
                }
                if (top.y + 1 < n && !visited[top.x][top.y + 1]) {
                    q.add(new Pair(top.x, top.y + 1));
                    visited[top.x][top.y + 1] = true;
                }
                if (top.x + 1 < m && !visited[top.x + 1][top.y]) {
                    q.add(new Pair(top.x + 1, top.y));
                    visited[top.x + 1][top.y] = true;
                }
                if (top.y - 1 >= 0 && !visited[top.x][top.y - 1]) {
                    q.add(new Pair(top.x, top.y - 1));
                    visited[top.x][top.y - 1] = true;
                }
                size--;
                
            }
            maxDistance++;
        }

        return --maxDistance == 0 ? -1 : maxDistance ;
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}