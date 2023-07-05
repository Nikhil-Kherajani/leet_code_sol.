class Solution {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int longestWindow = 0;
        int start = 0;
        final int n = nums.length;
        
        for (int i = 0; i < n ; i++) {
            zeroCount += (nums[i] == 0 ? 1 : 0);
                          
            while (zeroCount > 1) {
                zeroCount -= (nums[start] == 0 ? 1 : 0);
                start++;
            }
              
            longestWindow = Math.max(longestWindow, i - start);
        }

        return longestWindow;
    }
}