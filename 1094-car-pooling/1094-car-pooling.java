import java.util.*;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        final int n = trips.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.et, b.et));
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));
        // pq.add(new Pair(trips[0][0], trips[0][2]));
        // capacity -= trips[0][0];
        for (int i = 0; i < n; i++) {
            
            while (pq.size() > 0 && trips[i][1] >= pq.peek().et) {
                capacity += pq.poll().c;
            }
            if (capacity < trips[i][0]) {
                return false;
            }
            pq.add(new Pair(trips[i][0], trips[i][2]));
            capacity -= trips[i][0];
        }

        return true;

    }
}

class Pair {
    int et;
    int c;

    Pair(int c, int et) {
        this.et = et;
        this.c = c;
    }
}