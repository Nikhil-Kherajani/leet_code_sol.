import java.util.*;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] remaindersFreq = new int[k];
        remaindersFreq[0] = 1;
        int subarraysCount = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int rem = sum % k;
            if (rem < 0) {
                rem += k;
            }
            if (remaindersFreq[rem] >= 0) {
                subarraysCount += remaindersFreq[rem];
            }
            remaindersFreq[rem]++;

        }
        return subarraysCount;
    }
}