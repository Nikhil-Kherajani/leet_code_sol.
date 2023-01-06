import java.util.*;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] prices = new int[100005];
        int max = -1;
        for (int i = 0; i < costs.length; i++) {
            prices[costs[i]]++;
            if (costs[i] > max) {
                max = costs[i];
            }
        }
        int iceCreamsCount = 0;
        for (int i = 0; i <= max; i++) {
            if (prices[i] == 0) {
                continue;
            }
            if (i <= coins) {
                while (coins >= i && prices[i] > 0) {
                    iceCreamsCount += 1;
                    prices[i]--;
                    coins = coins - i;
                }

            }
        }

        return iceCreamsCount;
    }
}