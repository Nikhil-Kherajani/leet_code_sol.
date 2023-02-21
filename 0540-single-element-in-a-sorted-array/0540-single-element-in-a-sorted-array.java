class Solution {
    public int singleNonDuplicate(int[] nums) {
        final int n = nums.length;
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int m = (l + h) / 2;
            if (check(m, nums) == 0) {
                return nums[m];
            } else if (check(m, nums) == -1) {
                if (m % 2 != 0) {
                    l = m + 1;
                } else {
                    h = m - 2;
                }
            } else {
                if (m % 2 == 0) {
                    l = m + 2;
                } else {
                    h = m - 1;
                }
            }
        }
        return -1;
    }

    public int check(int m, int[] nums) {
        int temp = nums[m];
        if (m - 1 >= 0) {
            if (temp == nums[m - 1]) {
                return -1;
            }
        }
        if (m + 1 < nums.length) {
            if (temp == nums[m + 1]) {
                return 1;
            }
        }
        return 0;
    }

}