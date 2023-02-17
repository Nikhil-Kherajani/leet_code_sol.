class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int n = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            int l = 0;
            int r = n-1;
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

        return false;
    }
}