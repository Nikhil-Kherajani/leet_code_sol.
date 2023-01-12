import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int max = intervals[0][1];
        int min = intervals[0][0];
        int[][] ans = new int[10001][2];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {

            if (max >= intervals[i][0]) {
                max = Math.max(intervals[i][1], max);
            } else {
                ans[count][0] = min;
                ans[count][1] = max;
                count++;
                min = intervals[i][0];
                max = intervals[i][1];
            }

        }
        ans[count][0] = min;
        ans[count][1] = max;
        count++;

        // System.out.println(count);
        int[][] finalans = new int[count][2];
        for (int i = 0; i < count; i++) {
            finalans[i][0] = ans[i][0];
            finalans[i][1] = ans[i][1];

        }
        return finalans;

    }
}
