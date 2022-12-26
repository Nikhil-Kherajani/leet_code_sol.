class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lp = n-1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= lp) {
                lp = i;
            }

        }
        if (lp == 0) {
            return true;
        }
        return false;
    }
}