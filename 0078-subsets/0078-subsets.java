import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) != 0) {
                    temp.add(nums[j]);
                }
            }
            if (temp.size() > 0) {
                ans.add(temp);
            }
        }
        return ans;
    }
}