class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int least = prices[0];
        int max = -64;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] < max) {
                ans += max - least;
                max = -64;
                least = prices[i];
            }
            if (prices[i] < least) {
                least = prices[i];
            } else if (prices[i] > max) {
                max = prices[i];
            }
            
        }
        if (max == -64)
            return 0;
        else
            ans += max - least;
        
        return ans;
    }
}