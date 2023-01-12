class Solution {
    public void setZeroes(int[][] m) {
        int r = m.length, c = m[0].length;
        // int[][] a = new int[10000][10000];
        // int[][] b = new int[10000][10000];

        boolean[][] zeros = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (m[i][j] == 0) zeros[i][j] = true;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (zeros[i][j] == true) {
                    fillRowWithZeros(i, m);
                    fillColumnWithZeros(j, m);
                }
            }
        }
    }

    private void fillRowWithZeros(int row, int[][] m) {
        for (int i = 0; i < m[row].length; i++) {
            m[row][i] = 0;
        }
    }

    private void fillColumnWithZeros(int col, int[][] m) {
        for (int i = 0; i < m.length; i++) {
            m[i][col] = 0;
        }
    }
}