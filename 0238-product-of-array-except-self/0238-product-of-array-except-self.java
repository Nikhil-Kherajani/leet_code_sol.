import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        if (n == 2) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return nums;
        }
        int[] p = new int[n];
        int[] s = new int[n];
        p[0] = nums[0];
        for (int i = 1; i < n; i++) {
            p[i] = nums[i] * p[i-1];
        }
        s[n-1] = nums[n-1];
        for (int i = n - 2; i >= 0; i--) {
            s[i] = nums[i] * s[i+1];
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                nums[0] = s[1];
            } else if (i == n - 1) {
                nums[n - 1] = p[n - 2];
            } else {
                nums[i] = p[i - 1] * s[i + 1];
            }
        }

        return nums;

    }
}