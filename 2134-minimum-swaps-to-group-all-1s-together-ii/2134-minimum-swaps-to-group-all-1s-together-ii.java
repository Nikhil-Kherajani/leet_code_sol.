import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {

        int no = 0, n0 = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 1) {
                no++;
            }
        }
        if (no == nums.length) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < no; i++) {
            if (nums[i] == 0)
                n0++;
        }
        count = n0;
        int maxCount = count;
        int i = 1;
        for (; i < nums.length - no + 1; i++) {
            if (nums[i - 1] == 0 && nums[no - 1 + i] == 1) {
                n0--;

            } else if (nums[i - 1] == 1 && nums[no - 1 + i] == 0) {
                n0++;

            }
            count = n0;
            maxCount = Math.min(maxCount, count);

        }

        for (int j = 0; i < nums.length; i++, j++) {
            if (nums[i - 1] == 0 && nums[j] == 1) {
                n0--;

            } else if (nums[i - 1] == 1 && nums[j] == 0) {
                n0++;

            }
            count = n0;

            maxCount = Math.min(maxCount, count);

        }

        return maxCount;
    }
}