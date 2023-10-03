import java.util.HashMap;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i]) == true) {
                count += hm.get(nums[i]);
            }
            if (hm.containsKey(nums[i])) {
                int temp = hm.get(nums[i]);
                hm.put(nums[i], temp + 1);
            } else {
                hm.put(nums[i], 1);
            }
        }
        return count;
    }
}