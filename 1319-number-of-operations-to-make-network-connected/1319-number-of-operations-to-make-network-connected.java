import java.util.*;

class Solution {
    // private int ans = 0;
    private boolean[] visited;
    private int hogya = 0;
    private int i = 0;

    public int makeConnected(int n, int[][] connections) {
        ArrayList<Integer>[] net = new ArrayList[n];
        if (connections.length < n - 1) {
            return -1;
        }
        int dis = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            net[i] = new ArrayList<Integer>();
        }
        for (int[] val : connections) {
            net[val[0]].add(val[1]);
            net[val[1]].add(val[0]);
        }
        for (; i < n; i++) {
            hogya = 1;
            dfs(connections, net, i);
            if (hogya == 0) {
                dis++;
            }
        }

        return dis - 1;

    }

    public void dfs(int[][] connections, ArrayList<Integer>[] net, int cur) {

        if (visited[cur]) {
            // ans++;
            return;
        }
        hogya = 0;
        visited[cur] = true;

        for (int i = 0; i < net[cur].size(); i++) {
            dfs(connections, net, net[cur].get(i));
        }
    }

}