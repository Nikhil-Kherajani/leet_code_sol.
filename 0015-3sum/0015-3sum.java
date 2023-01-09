import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                // System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);
                if (nums[left] + nums[right] + nums[i] == 0) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    triplets.add(temp);
                    left++;
                    while (left - 1 >= 0 && left < right && nums[left - 1] == nums[left])
                        left++;
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                    while (right + 1 < nums.length && right > left && nums[right] == nums[right + 1])
                        right--;
                } else {
                    left++;
                    while (left - 1 >= 0 && left < right && nums[left - 1] == nums[left])
                        left++;
                }
            }
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return triplets;
    }
}