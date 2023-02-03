class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                if (nums1[i] != nums2[i]) {
                    return -1;
                }
            }
            return 0;
        }
        long plus = 0;
        long minus = 0;
        for (int i = 0; i < n; i++) {
            if (nums1[i] > nums2[i]) {
                if ((nums1[i] - nums2[i]) % k == 0) {
                    plus += (nums1[i] - nums2[i]) / k;
                } else {
                    plus += 1;
                }
            } else if (nums1[i] < nums2[i]) {
                if ((nums2[i] - nums1[i]) % k == 0) {
                    minus += (nums2[i] - nums1[i]) / k;
                } else {
                    minus += -1;
                }

            }

        }
        if (plus != minus) {
            return -1;
        }
        return plus;
    }
}