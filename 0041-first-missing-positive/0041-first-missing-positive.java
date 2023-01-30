import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] arr = new boolean[n + 5];
        arr[0] = true;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] < n + 5)
                arr[nums[i]] = true;
        }
        int i = 0;
        for (; i < n + 5; i++) {
            if (!arr[i]) {
                break;
            }
        }
        return i;
    }
}