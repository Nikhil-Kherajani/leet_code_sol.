class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
         int n=candidates.size();
    
    sort(candidates.begin(),candidates.end());
    
    vector<vector<int>>ans;
   vector<int>ds;
    
    fun(0,candidates,target,n,ans,ds);
    
    return ans;
    }
    void fun(int ind,vector<int>&arr,int tar,int n,vector<vector<int>>&ans,vector<int>&ds){
    
    if(tar==0){
        ans.push_back(ds);
        return;
    }
    
    for(int i=ind;i<n;i++){
        if(i>ind && arr[i]==arr[i-1]) continue;
        
         if(arr[i]<=tar){
             ds.push_back(arr[i]);
             fun(i+1,arr,tar-arr[i],n,ans,ds);
                 ds.pop_back();
         }
        else 
            break;
    }
}
};