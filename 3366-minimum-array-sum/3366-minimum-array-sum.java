class Solution {
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int[][][] dp = new int[nums.length+1][op1+1][op2+1];
        for(int[][] ele2: dp){
            for(int[] ele1: ele2){
                Arrays.fill(ele1,-1);
            }
        }
        return solve(nums,0,op1,op2,k,dp);
    }
    public int solve(int[] nums, int i,int op1, int op2, int k, int[][][] dp){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i][op1][op2] != -1){
            return dp[i][op1][op2];
        }
        int operation1 = Integer.MAX_VALUE;
        if(op1 > 0){
            int temp =  (int)Math.ceil(nums[i]/(2*1.0));
            int val1 = temp+solve(nums,i+1,op1-1,op2,k,dp);
            int val2 = Integer.MAX_VALUE;
            if(temp >= k && op2 > 0){
                val2 = (temp-k) + solve(nums,i+1,op1-1,op2-1,k,dp);
            }
            operation1 = Math.min(val1,val2);
        }
        int operation2 = Integer.MAX_VALUE;
        if(op2 > 0 && nums[i] >= k){
            int temp = nums[i]-k;
            int val1 = temp + solve(nums,i+1,op1,op2-1,k,dp);
            int val2 = Integer.MAX_VALUE;
            if(op1 > 0){
                val2 = (int) Math.ceil(temp/(2*1.0)) + solve(nums,i+1,op1-1,op2-1,k,dp);
            }
            operation2 = Math.min(val1,val2);
        }
        int skip = nums[i] + solve(nums,i+1,op1,op2,k,dp);
        return dp[i][op1][op2] = Math.min(skip,Math.min(operation1,operation2));
    }
}