class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<vector<int>> v(nums.size(),vector<int>(nums.size()+1,-1));
        return fun(v,nums,0,-1);
    }
    int fun(vector<vector<int>>& dp,vector<int>& nums,int ind,int prev)
    {
        if(ind>=nums.size())
            return 0;
        
        if(dp[ind][prev+1]!=-1)
            return dp[ind][prev+1];
        
        int t=fun(dp,nums,ind+1,prev);
        if(prev==-1 || nums[ind]>nums[prev])
            t=max(t,1+fun(dp,nums,ind+1,ind));
        
        return dp[ind][prev+1]=t;
    }
};