import java.util.*;

class Pair {
    int sub;
    int time;

    public Pair(int x, int y) {
        this.sub = x;
        this.time = y;
    }
}

class Solution {
    ArrayList<Pair>[] map;
    // private int nn;
    private int max = Integer.MIN_VALUE;
    private boolean[] v;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // nn = n;
        map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] == -1) {
                continue;
            }
            map[manager[i]].add(new Pair(i, informTime[manager[i]]));
        }
        v = new boolean[n];
        dfs(headID, 0, informTime);
        return max;
    }

    public void dfs(int i, int time, int[] informTime) {
        time = time + informTime[i];
        for (int j = 0; j < map[i].size(); j++) {
            dfs(map[i].get(j).sub, time, informTime);
        }
        max = Math.max(max, time);
    }
}
