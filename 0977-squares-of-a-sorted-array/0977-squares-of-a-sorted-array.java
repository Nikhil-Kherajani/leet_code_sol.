import java.util.*;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int center = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                center = i;
                break;
            }
        }
        // result[0] = nums[center] * nums[center];
        int l = center - 1;
        int r = center;
        int i = 0;
        while (l >= 0 && r < n) {
            if ((nums[l] * -1) < nums[r]) {
                result[i] = nums[l] * nums[l];
                i++;
                l--;
            } else if ((nums[l] * -1) > nums[r]) {
                result[i] = nums[r] * nums[r];
                i++;
                r++;
            } else {
                result[i] = nums[r] * nums[r];
                i++;
                result[i] = nums[r] * nums[r];
                i++;
                r++;
                l--;
            }
        }
        while (l >= 0) {
            result[i] = nums[l] * nums[l];
            i++;
            l--;
        }
        while (r < n) {
            result[i] = nums[r] * nums[r];
            i++;
            r++;
        }
        return result;
    }
}