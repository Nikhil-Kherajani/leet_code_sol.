class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        vector<vector<int>> ans;
        if(intervals.size()==0) return ans;
        int x=intervals[0][0],y=intervals[0][1];
        for(int i=0;i<intervals.size();i++){
            if(x<=intervals[i][0] && y>=intervals[i][0]){
                y=max(intervals[i][1],y);
            }
            else {
                ans.push_back({x,y});
                x=intervals[i][0];
                y=intervals[i][1];
            }
        }
        ans.push_back({x,y});
        return ans;
    }
};