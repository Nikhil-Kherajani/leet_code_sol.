class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int n = matrix[0].length;
        final int m = matrix.length;
        if (n > m) {
            for (int i = 0; i < m; i++) {
                int l = 0;
                int r = n - 1;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (target > matrix[i][mid]) {
                        l = mid + 1;
                    } else if (target < matrix[i][mid]) {
                        r = mid - 1;
                    } else {
                        return true;
                    }
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                int l = 0;
                int r = m - 1;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (target > matrix[mid][i]) {
                        l = mid + 1;
                    } else if (target < matrix[mid][i]) {
                        r = mid - 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}