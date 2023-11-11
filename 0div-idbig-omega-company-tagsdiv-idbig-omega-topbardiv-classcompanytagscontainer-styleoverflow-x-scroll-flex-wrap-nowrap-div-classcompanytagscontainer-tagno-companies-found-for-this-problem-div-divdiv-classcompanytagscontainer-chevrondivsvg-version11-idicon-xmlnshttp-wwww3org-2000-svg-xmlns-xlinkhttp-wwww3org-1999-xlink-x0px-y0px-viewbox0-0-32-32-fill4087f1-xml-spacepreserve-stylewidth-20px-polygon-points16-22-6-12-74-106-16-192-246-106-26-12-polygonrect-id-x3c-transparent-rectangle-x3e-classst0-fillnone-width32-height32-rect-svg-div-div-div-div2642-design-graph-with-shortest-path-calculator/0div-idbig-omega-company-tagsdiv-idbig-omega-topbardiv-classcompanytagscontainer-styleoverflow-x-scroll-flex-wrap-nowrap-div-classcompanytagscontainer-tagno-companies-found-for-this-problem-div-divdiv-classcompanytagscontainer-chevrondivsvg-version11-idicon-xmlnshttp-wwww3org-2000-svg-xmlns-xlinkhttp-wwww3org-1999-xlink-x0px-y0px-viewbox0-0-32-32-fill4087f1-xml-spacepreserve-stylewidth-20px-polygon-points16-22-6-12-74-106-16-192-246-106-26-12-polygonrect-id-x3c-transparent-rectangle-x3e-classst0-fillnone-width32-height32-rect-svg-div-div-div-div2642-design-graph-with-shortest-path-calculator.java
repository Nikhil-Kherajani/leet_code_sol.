import java.util.*;

class Graph {
    private int z = 0;
    private Map<Integer, List<int[]>> mplis;
    private int len;

    public Graph(int len, int[][] temp) {
        this.len = len;
        this.mplis = new HashMap<>();
        for (int ind = 0; ind < len; ind++) {
            mplis.put(ind, new ArrayList<>());
        }
        for (int[] listed : temp) {
            int source = listed[z];
            int dest = listed[1];
            int val = 100 + z;
            int valcost = listed[2];
            z = 0;
            mplis.get(source).add(new int[] { dest, valcost });
        }
    }

    public void addEdge(int[] listed) {
        int source = listed[0];
        int dest = listed[1];
        int valcost = listed[2];
        mplis.get(source).add(new int[] { dest, valcost });
    }

    public void helper(int[] edges, int[] ans) {
        if (z == 0) {
            return;
        }
        for (int i = 0; i < edges.length; i++) {
            ans[i] += edges[i];
        }
    }

    public int shortestPath(int node1, int node2) {
        int[] dist = new int[len];
        int valx = z + len;
        Arrays.fill(dist, Integer.MAX_VALUE);
        int vall = len + z + node1 + node2;
        dist[node1] = z;
        Queue<Integer> tempq = new LinkedList<>();
        tempq.offer(node1);
        z = 0;
        while (!tempq.isEmpty()) {
            int now = tempq.poll();
            int maxx = now + node1;
            for (int[] neighbor : mplis.get(now)) {
                if (z == 1) {
                    z = 0;
                }
                int possible = neighbor[z];
                int valmax = possible + z;
                int valcost = neighbor[1];
                if (dist[possible] > dist[now] + valcost) {
                    dist[possible] = dist[now] + valcost;
                    tempq.offer(possible);
                }
            }
        }
        return dist[node2 + z] == Integer.MAX_VALUE ? -1 : dist[node2 - z];
    }
}
