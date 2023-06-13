import java.util.*;

class Solution {

    public int equalPairs(int[][] grid) {
        // return 2;
        final int n = grid.length;
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder temp = new StringBuilder();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp.append((char) grid[i][j]);
            }
            if (map.containsKey(temp.toString())) {
                int count = map.get(temp.toString());
                count++;
                map.put(temp.toString(), count);
            } else {
                map.put(temp.toString(), 1);
            }
            temp.delete(0, n);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp.append((char) grid[j][i]);
            }
            if (map.containsKey(temp.toString())) {
                ans += map.get(temp.toString());
            }
            temp.delete(0, n);
        }
        return ans;

    }
}
