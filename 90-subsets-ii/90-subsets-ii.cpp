class Solution {
public:
    void fun(int ind,vector<int>& ds,vector<vector<int>>& res,vector<int>& nums,int n){
        if(ind==n){
            res.push_back(ds);
            return;
        }
        ds.push_back(nums[ind]);
        fun(ind+1,ds,res,nums,n);
        
        ds.pop_back();
        fun(ind+1,ds,res,nums,n);
    }
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(begin(nums),end(nums));
        vector<vector<int>> res,v;
        vector<int> ds;
        int n=size(nums);
        fun(0,ds,res,nums,n);
        set<vector<int>> s;
        for(auto& x: res)
            s.insert(x);
        for(auto& x:s)
            v.push_back(x);
        return v;
    }
};
