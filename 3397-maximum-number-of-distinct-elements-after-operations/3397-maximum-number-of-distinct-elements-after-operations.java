import java.util.Arrays;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        long lastAssigned = Long.MIN_VALUE;
        int count = 0;
        
        for (int num : nums) {
            int lower = num - k;
            int upper = num + k;
            long assign = lastAssigned + 1;
            
            if (assign < lower) {
                assign = lower;
            }
            
            if (assign <= upper) {
                count++;
                lastAssigned = assign;
            }
        }
        
        return count;
    }
}