class Solution {    
    public int numOfArrays(int n, int m, int k) {    
        int[][] dp = new int[m + 1][k + 1];
        int[][] prevDp = new int[m + 1][k + 1];
        int MOD = (int) 1e9 + 7;
        
        for (int num = 0; num < dp.length; num++) {
            prevDp[num][0] = 1;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            dp = new int[m + 1][k + 1];
            for (int maxSoFar = m; maxSoFar >= 0; maxSoFar--) {
                for (int remain = 0; remain <= k; remain++) {
                    int ans = 0;
                    for (int num = 1; num <= maxSoFar; num++) {
                        ans = (ans + prevDp[maxSoFar][remain]) % MOD;
                    }
                    
                    if (remain > 0) {
                        for (int num = maxSoFar + 1; num <= m; num++) {
                            ans = (ans + prevDp[num][remain - 1]) % MOD;
                        }
                    }
                    
                    dp[maxSoFar][remain] = ans;
                }
            }
            
            prevDp = dp;
        }

        return dp[0][k];
    }
}