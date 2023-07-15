class Solution 
{
    public int fun(int i,int[][] nums,int prev,int max,int[][] dp)
    {
        if(i==nums.length || max==0)  return 0;

        if(dp[prev+1][max]!=-1)  
         return dp[prev+1][max];

        int take=0;
        int not=0;
        if(prev==-1 || nums[prev][1]<nums[i][0])
        {
            take=nums[i][2]+fun(i+1,nums,i,max-1,dp);
        }
        not=0+fun(i+1,nums,prev,max,dp);
        return dp[prev+1][max]=Math.max(take,not);
    }
    public int maxValue(int[][] events, int k) 
    {
        Arrays.sort(events,(a,b) -> 
        {
            if(a[1]==b[1])  return a[0]-b[0];
            return a[1]-b[1];
        });
       int[][] dp=new int[events.length+1][k+1];
       for(int[] j : dp) Arrays.fill(j,-1);
        return fun(0,events,-1,k,dp);
    }
}