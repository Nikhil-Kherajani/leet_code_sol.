class Solution {
    int mod=1000000007;
    public int trav(int n,int p,int group[],int profit[],int index,int dp[][][])
    {
        int ans=0;
        if(n<0)
            return ans;
        if(index>=group.length)
        {
            if(p<=0)
                return 1;
            return ans;
        }
        if(p<0)
            p=0;
        if(dp[index][n][p]!=-1)
            return dp[index][n][p];
        ans=(ans%mod+trav(n-group[index],p-profit[index],group,profit,index+1,dp)%mod)%mod;
        ans=(ans%mod+trav(n,p,group,profit,index+1,dp)%mod)%mod;
        dp[index][n][p]=ans;
        return ans;
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int dp[][][]=new int[profit.length][n+1][minProfit+1];
        for(int i=0;i<profit.length;i++)
            for(int j=0;j<=n;j++)
                for(int k=0;k<=minProfit;k++)
                    dp[i][j][k]=-1;
        return trav(n,minProfit,group,profit,0,dp);
    }
}