class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int left = k;
        int right = k;
        int ans = nums[k];
        int currMin = nums[k];
        
        while (left > 0 || right < n - 1) {
            if ((left > 0 ? nums[left - 1]: 0) < (right < n - 1 ? nums[right + 1] : 0)) {
                right++;
                currMin = Math.min(currMin, nums[right]);
            } else {
                left--;
                currMin = Math.min(currMin, nums[left]);
            }
            
            ans = Math.max(ans, currMin * (right - left + 1));
        }
        
        return ans;
    }
}