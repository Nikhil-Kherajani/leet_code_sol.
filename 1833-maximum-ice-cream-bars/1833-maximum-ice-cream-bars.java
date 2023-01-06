import java.util.*;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int iceCreamsCount = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins - costs[i] >= 0) {
                iceCreamsCount++;
                coins -= costs[i];
            } else {
                break;
            }
        }
        return iceCreamsCount;
    }
}