class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int[] possiblePaths = new int[n + 1];
        possiblePaths[n] = 0;
        possiblePaths[n - 1] = 1;
        possiblePaths[n - 2] = 2;

        for (int i = n - 3; i >= 0; i--) {
            possiblePaths[i] = possiblePaths[i+2] + possiblePaths[i+ 1];
        }

        return possiblePaths[0];
    }
}