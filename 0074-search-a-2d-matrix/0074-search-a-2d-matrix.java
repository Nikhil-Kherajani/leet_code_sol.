class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int l = 0;
        final int n = matrix[0].length;
        int r = matrix.length * n-1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target > matrix[mid / n][mid % n]) {
                l = mid + 1;
            } else if (target < matrix[mid / n][mid % n]) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}