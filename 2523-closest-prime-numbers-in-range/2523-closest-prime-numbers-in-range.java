import java.util.Arrays;
import java.util.*;

class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] prime = new boolean[1000005];
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i * i < 1000005; i++) {
            if (prime[i]) {
                for (int j = i * i; j < 1000005; j += i) {
                    prime[j] = false;
                }
            }
        }
        int mindif = Integer.MAX_VALUE;
        int j = 0, k = 0;
        for (int i = left; i <= right; i++) {
            // System.out.println(ans.size());
            if (prime[i] && ans.size() < 2) {
                ans.add(i);
            }
            if (ans.size() == 2) {
                // System.out.println(ans.get(0) + " " + ans.get(1));
                if (mindif > ans.get(1) - ans.get(0)) {
                    j = ans.get(0);
                    k = ans.get(1);
                    mindif = k - j;
                    ans.remove(0);

                } else {
                    ans.remove(0);
                }
            }
        }
        if (j == 0 || k == 0) {
            int[] notans = new int[2];
            notans[0] = -1;
            notans[1] = -1;

            return notans;
        }
        int[] realans = new int[2];
        realans[0] = j;
        realans[1] = k;

        return realans;

    }
}