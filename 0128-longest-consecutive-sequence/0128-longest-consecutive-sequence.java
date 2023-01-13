import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        int count = 0, maxCount = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int val : nums) {
            set.add(val);
        }
        for (int val : nums) {
            if (!set.contains(val - 1)) {
                count = 1;

                while (set.contains(val + 1)) {
                    val++;
                    count++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
}