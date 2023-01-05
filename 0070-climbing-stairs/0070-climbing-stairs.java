class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int oneAfter = 2;
        int twoAfter = 1;

        for (int i = n - 3; i >= 0; i--) {
            int temp = oneAfter;
            oneAfter = oneAfter + twoAfter;
            twoAfter = temp;
        }

        return oneAfter;
    }
}