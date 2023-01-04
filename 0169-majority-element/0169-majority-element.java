class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int lives = 1;
        for (int i = 1; i < nums.length; i++) {
            if (lives != 0 && candidate != nums[i]) {
                lives--;
            } else if (candidate == nums[i]) {
                lives++;
            } else if (lives == 0) {
                candidate = nums[i];
            }
        }
        return candidate;
    }
}