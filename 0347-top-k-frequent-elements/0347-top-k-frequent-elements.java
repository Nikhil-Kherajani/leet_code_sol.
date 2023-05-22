import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int val : nums) {
            if (m.containsKey(val)) {
                int freq = m.get(val);
                m.put(val, freq + 1);
            } else {
                m.put(val, 1);
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.y, b.y));
        for (int key : m.keySet()) {
            pq.add(new Pair(key, m.get(key)));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[k];
        int i = 0;
        while (pq.size() > 0) {
            ans[i++] = pq.poll().x;
        }
        return ans;

    }
}