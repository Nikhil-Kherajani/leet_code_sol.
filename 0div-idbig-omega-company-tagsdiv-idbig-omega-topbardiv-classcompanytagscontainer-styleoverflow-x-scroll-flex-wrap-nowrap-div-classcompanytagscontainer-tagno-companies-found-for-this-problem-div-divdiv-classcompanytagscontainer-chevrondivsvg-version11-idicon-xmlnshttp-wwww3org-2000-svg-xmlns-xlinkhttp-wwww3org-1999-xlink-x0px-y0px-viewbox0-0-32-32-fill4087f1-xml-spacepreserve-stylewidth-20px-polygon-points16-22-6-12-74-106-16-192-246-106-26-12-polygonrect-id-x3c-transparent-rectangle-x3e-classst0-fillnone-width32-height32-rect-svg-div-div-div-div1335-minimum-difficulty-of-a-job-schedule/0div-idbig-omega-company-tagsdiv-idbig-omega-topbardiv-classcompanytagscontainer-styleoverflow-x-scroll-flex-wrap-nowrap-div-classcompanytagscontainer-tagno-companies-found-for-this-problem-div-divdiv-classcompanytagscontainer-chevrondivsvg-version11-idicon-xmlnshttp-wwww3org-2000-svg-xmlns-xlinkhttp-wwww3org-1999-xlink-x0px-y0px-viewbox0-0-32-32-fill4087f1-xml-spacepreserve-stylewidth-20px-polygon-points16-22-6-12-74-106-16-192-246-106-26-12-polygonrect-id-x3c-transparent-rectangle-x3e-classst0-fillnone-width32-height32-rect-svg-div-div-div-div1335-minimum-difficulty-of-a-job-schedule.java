class Solution {
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d>jobDifficulty.length)return -1;
        int n = jobDifficulty.length;
        int[][] dp = new int[n][d+1];
        dp[0][1]=jobDifficulty[0];

        for(int i=1;i<n;i++){
            int a = jobDifficulty[i];
            dp[i][1]=Math.max(a,dp[i-1][1]);
            for(int j=2;j<=Math.min(d,i+1);j++){
                int m = a,ans=Integer.MAX_VALUE;
                for(int k=i;k>=j-1;k--){
                    m = Math.max(m,jobDifficulty[k]);
                    ans = Math.min(ans,m+dp[k-1][j-1]);
                }
                dp[i][j]=ans;
            }
        }
        return dp[n-1][d];
    }
}