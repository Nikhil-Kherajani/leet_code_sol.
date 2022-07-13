class Solution {
public:
    bool canJump(vector<int>& nums) {

        int len = nums.size();
        int prev_point = 0, point;
        
        if (len == 1)
            return true;
        
        for (int i=1; i<len; i++) {            
            point = max(nums[i-1]-1, prev_point - 1);
         
            if (point < 0)
                 return false; // not reachable

            prev_point = point;
        }
        return true;
    }
};