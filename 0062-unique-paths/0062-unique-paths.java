class Solution {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        paths[m - 1][n - 1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (j < n - 1) {
                    paths[i][j] += paths[i][j + 1];
                }
                if (i < m - 1) {
                    paths[i][j] += paths[i + 1][j];
                }
            }
        }

        return paths[0][0];
    }
}