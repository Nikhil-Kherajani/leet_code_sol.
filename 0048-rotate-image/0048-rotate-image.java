class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int k = 0;
        for (int i = n; i >= 2; i -= 2) {
            rotateMatrix(matrix, n-k, k);
        
            k++;
        }

    }

    public void rotateMatrix(int[][] matrix, int n, int k) {
        int[] row = new int[n];
        int i = k, j;
        for (j = k; j < n; j++) {
            row[j] = matrix[i][j];
        }
        j = n - 1;
        for (i = k; i < n; i++) {
            swap(matrix, row, i, j, i);

        }
        i = n - 1;
        int r = k;
        for (j = n - 1; j >= k; j--) {
            swap(matrix, row, i, j, r);

            r++;
        }
        j = k;
        r = 1 + k;
        for (i = n - 2; i >= k; i--) {
            swap(matrix, row, i, j, r);
            // System.out.println(row[r]);
            r++;
        }
        i = k;
        for (j = 1 + k; j < n; j++) {
            swap(matrix, row, i, j, j);
        }

    }

    public void swap(int[][] matrix, int[] row, int i, int j, int r) {
        int temp = matrix[i][j];
        matrix[i][j] = row[r];
        row[r] = temp;
    }

}