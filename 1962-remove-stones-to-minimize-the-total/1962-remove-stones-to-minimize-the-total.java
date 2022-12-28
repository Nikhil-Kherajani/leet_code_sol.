import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;

class Solution {
    public int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer lhs, Integer rhs) {
                if (lhs < rhs)
                    return +1;
                if (lhs.equals(rhs))
                    return 0;
                return -1;
            }
        });
        for (int i = 0; i < piles.length; i++) {
            pq.add(piles[i]);
        }
        // System.out.println(pq.size());
        double two = 2;

        while (pq.size() > 0 && k > 0) {
            // System.out.println((int) Math.ceil(pq.remove() / two));
            pq.add((int) Math.ceil(pq.remove() / two));

            k--;
        }
        int ans = 0;
        while (pq.size() > 0) {
            System.out.println(pq.peek());
            ans += pq.remove();
        }

        return ans;

    }
}