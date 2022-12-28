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
       
        double two = 2;

        while (pq.size() > 0 && k > 0) {
            
            pq.add((int) Math.ceil(pq.remove() / two));

            k--;
        }
        int ans = 0;
        while (pq.size() > 0) {
            
            ans += pq.remove();
        }

        return ans;

    }
}