class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n=nums.size();
       unordered_map<int,int>mp;
        int ele;
        for(int i=0;i<nums.size();i++)
        {
            mp[nums[i]]++;
        }
        for(auto x:mp)
        {
            if(x.second>n/2)
            {   
                ele = x.first;
                break;
            }
        }
        return ele;
    }
};