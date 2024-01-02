import java.util.*;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] numsnew = new int[201];
        int total = 0;
        for (int val : nums) {
            numsnew[val]++;
            total++;
        }

        while (total > 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < 201; i++) {
                if (numsnew[i] > 0) {
                    temp.add(i);
                    numsnew[i]--;
                    total--;
                }
            }
            ans.add(temp);
        }

        return ans;
    }
}