class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        int length = 1; // Length of LIS
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < dp[0]) {
                dp[0] = nums[i]; // Update smallest value
            } else if (nums[i] > dp[length - 1]) {
                dp[length] = nums[i]; // Extend LIS
                length++;
            } else {
                // Binary search to find the position to replace in dp
                int index = Arrays.binarySearch(dp, 0, length, nums[i]);
                if (index < 0) {
                    index = -index - 1;
                }
                dp[index] = nums[i];
            }
        }

        return length;
    }
}