import java.util.Arrays;

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int[] dif = new int[n];
        for (int i = 0; i < n; i++) {
            dif[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(dif);
        // if (dif[n - 1] == 0) {
        // return n;
        // }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dif[i] > 0 && additionalRocks >= dif[i]) {
                count++;
                additionalRocks -= dif[i];
            }
            if (dif[i] == 0) {
                count++;
            }
        }

        return count;
    }
}