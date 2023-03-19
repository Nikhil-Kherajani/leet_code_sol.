import java.util.*;

class Solution {
    public long findScore(int[] nums) {
        final int n = nums.length;
        long score = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.x, b.x) == 0 ? Integer.compare(a.y, b.y) : Integer.compare(a.x, b.x));
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(nums[i], i));
        }
        while (pq.size() > 0) {
            Pair top = pq.poll();
            if (!visited[top.y]) {
                visited[top.y] = true;
                if (top.y > 0) {
                    visited[top.y - 1] = true;
                }
                if (top.y < n - 1) {
                    visited[top.y + 1] = true;
                }
                score += top.x;
            }
        }

        return score;
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}