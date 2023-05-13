class Solution {
    private int[] dp;
    private int m = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new int[high + 1];
        for(int i = 0 ; i <= high  ; i++ ){
            dp[i] = -1;
        }
        return solve(0 , low , high , zero , one);
    }
    
    public int solve(int l, int low, int high, int zero, int one){
        
        int ans = 0;
        if(l >= low && l <= high){
            ans++;
        }
        if(l > high){
            return 0;
        }
        if(dp[l] != -1){
            return dp[l];
        }
        
        ans += (solve(l + one , low , high , zero , one)%m);
        ans += (solve(l + zero , low , high , zero , one)%m);
        
        return dp[l] = ans % m;
    }
}