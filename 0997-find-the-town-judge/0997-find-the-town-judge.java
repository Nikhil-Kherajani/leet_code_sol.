import java.util.*;

class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean[] nums = new boolean[n + 1];
        for (int i = 0; i < trust.length; i++) {
            if (!nums[trust[i][0]]) {
                nums[trust[i][0]] = true;
            }
        }
        int judge = -1;
        for (int i = 1; i <= n; i++) {
            if (!nums[i]) {
                judge = i;
                break;
            }
        }
        if (judge == -1) {
            return -1;
        }
        Arrays.fill(nums, false);
        nums[judge] = true;
        for (int i = 0; i < trust.length; i++) {
            if (trust[i][1] == judge) {
                nums[trust[i][0]] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!nums[i]) {
                return -1;
            }
        }

        return judge;
    }
}