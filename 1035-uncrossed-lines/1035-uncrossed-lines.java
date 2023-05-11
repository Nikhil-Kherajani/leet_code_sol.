class Solution {
    private int[][] dp;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        dp = new int[505][505];
        for(int i = 0 ; i < 505 ; i++){
            for(int j = 0 ; j < 505 ; j++){
                dp[i][j] = -1;
            }
        }
        return solve(0,0, nums1 , nums2);
    }
    
    public int solve(int i , int j , int[] nums1 , int[] nums2){
        
        if(i >= nums1.length || j >= nums2.length ){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(nums1[i] == nums2[j]){
            return dp[i][j] = 1 + solve(i + 1 , j + 1 , nums1 , nums2);
        }
        else{
            return dp[i][j] = Math.max(solve(i , j +1 , nums1 , nums2) ,solve(i+1 , j , nums1 , nums2) );
        }
        
    }
}