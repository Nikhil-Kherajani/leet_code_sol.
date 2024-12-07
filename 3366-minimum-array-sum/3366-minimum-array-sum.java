import java.util.Arrays;

class Solution {
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int n = nums.length;
        long[][][] dp = new long[n + 1][op1 + 1][op2 + 1];
        for (long[][] row : dp) {
            for (long[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        return (int) solve(nums, k, op1, op2, 0, dp);
    }

    private long solve(int[] nums, int k, int op1, int op2, int index, long[][][] dp) {
        if (index == nums.length) {
            return 0;
        }

        if (dp[index][op1][op2] != -1) {
            return dp[index][op1][op2];
        }

        // Option 1: Skip both operations
        long ans = nums[index] + solve(nums, k, op1, op2, index + 1, dp);

        // Option 2: Apply only operation 1
        if (op1 > 0) {
            ans = Math.min(ans, (nums[index] + 1) / 2 + solve(nums, k, op1 - 1, op2, index + 1, dp));
        }

        // Option 3: Apply only operation 2
        if (op2 > 0 && nums[index] >= k) {
            ans = Math.min(ans, nums[index] - k + solve(nums, k, op1, op2 - 1, index + 1, dp));
        }

        // Option 4: Apply operation 1 then operation 2
        if (op1 > 0 && op2 > 0) {
            int nextVal = (nums[index] + 1) / 2;
            if (nextVal >= k) {
                ans = Math.min(ans, nextVal - k + solve(nums, k, op1 - 1, op2 - 1, index + 1, dp));
            } else if (op1 > 1){
                ans = Math.min(ans, Math.max(0, nextVal) + solve(nums, k, op1 - 1, op2, index+1, dp) );

            }
             else {
                ans = Math.min(ans, nextVal + solve(nums,k,op1-1,op2,index+1,dp));
            }
        }

        // Option 5: Apply operation 2 then operation 1
        if (op1 > 0 && op2 > 0 && nums[index] >= k) {
            ans = Math.min(ans, (nums[index]-k+1)/2 + solve(nums, k, op1-1, op2-1, index+1, dp));
        }
        

        return dp[index][op1][op2] = ans;
    }
}