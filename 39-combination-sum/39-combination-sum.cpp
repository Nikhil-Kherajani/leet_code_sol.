class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
      int n=candidates.size();
     vector<vector<int>>ans;
    vector<int>ds;
    
    fun(0,candidates,target,n,ans,ds);
    
    return ans;
    

    }
                     
void fun(int ind,vector<int>&arr,int tar,int n,vector<vector<int>>&ans,vector<int>&ds){
    
    
    if(ind==n){
    if(tar==0){
        ans.push_back(ds);
        
       }
        return;
    }
        
         if(arr[ind]<=tar){
             ds.push_back(arr[ind]);
             fun(ind,arr,tar-arr[ind],n,ans,ds);
                 ds.pop_back();
             
         }
     
       fun(ind+1,arr,tar,n,ans,ds);
    }



   
};