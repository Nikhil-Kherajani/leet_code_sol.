import java.util.ArrayList;

class Solution {
    int[] helper = new int[500];

    public int rob(int[] nums) {

        for (int i = 0; i < helper.length; i++) {
            helper[i] = -1;
        }
        return getsum(nums, 0);
    }

    public int getsum(int[] nums, int i) {

        if (i >= nums.length) {
            return 0;
        }
        if (helper[i] != -1) {
            return helper[i];
        }

        int inculde = getsum(nums, i + 2) + nums[i];
        int notinculde = getsum(nums, i + 1);
        int sum = Math.max(inculde, notinculde);
        helper[i] = sum;
        return sum;
    }
}