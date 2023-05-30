class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return getMaxAmount(nums, nums.length - 1, dp);
    }
    
    
    public int getMaxAmount(int[] nums, int n, int[] dp) {
       if(n < 0) return 0; 
       if(n == 0) return nums[0];
       if(n == 1) return Integer.max(nums[1], nums[0]);
       if(dp[n] != -1) return dp[n]; 
       dp[n] = Integer.max(nums[n] + getMaxAmount(nums, n-2, dp), getMaxAmount(nums, n-1, dp));
       return dp[n]; 
    }
}
