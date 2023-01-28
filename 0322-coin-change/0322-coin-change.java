class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int n = coins.length;
        Arrays.sort(coins);
        dp[amount] = 0;
        for( int i = amount - 1; i >=0 ; i--){
            int j = 0;
            int min = Integer.MAX_VALUE;
            while(coins[j] <= amount - i){
                min = Math.min(dp[i + coins[j]] , min);
                j++; 
                if(j == n){
                    break;
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min +1;
        }
        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }
}