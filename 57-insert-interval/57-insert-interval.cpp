class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        intervals.push_back(newInterval);
        sort(intervals.begin(),intervals.end());
        int start=intervals[0][0],end=intervals[0][1];
        int n=intervals.size();
        if(n==1)return intervals;
        vector<vector<int>>v;
        int i=1;
        while(i<n){
            if(intervals[i][0]<=end){
                if(intervals[i][1]>end)end=intervals[i][1];
                i++;
            }
            else if(intervals[i][0]>start){
                v.push_back({start,end});
                start=intervals[i][0];
                end=intervals[i][1];
                i++;
            }
        }
        v.push_back({start,end});
        return v;
    }
};