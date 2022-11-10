class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] res = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                applyRules(row, col, board, res);
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                board[row][col] = res[row][col];
            }
        }
    }

    private void applyRules(int row, int col, int[][] grid, int[][] res) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r == row && c == col) continue;
                if (cellExists(r, c, grid)) {
                    count += grid[r][c];
                }
            }
        }
        if (count < 2 || count > 3) res[row][col] = 0;
        else if (count == 3) res[row][col] = 1;
        else res[row][col] = grid[row][col];
    }

    private boolean cellExists(int row, int col, int[][] grid) {
        return (row <= grid.length - 1 && row >= 0) && (col <= grid[0].length - 1 && col >= 0);
    }
}