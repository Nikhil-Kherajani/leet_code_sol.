class Solution {
    

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, int[] memo) {

        if (n == 1) memo[1] = 1;
        if (n == 2) memo[2] = 2;

        if (memo[n] > 0) return memo[n];

        return memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
    }

}