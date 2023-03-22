import java.util.*;

class Solution {
    public int minScore(int n, int[][] roads) {
        HashMap<Integer, ArrayList<Pair>> mp = new HashMap<>();
        int min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        for (int[] val : roads) {
            // System.out.println(val[0] + " " + val[1] + " " + val[2]);
            if (!mp.containsKey(val[0])) {
                ArrayList<Pair> temp = new ArrayList<>();
                temp.add(new Pair(val[1], val[2]));
                mp.put(val[0], temp);

            } else {
                ArrayList<Pair> temp = mp.get(val[0]);
                temp.add(new Pair(val[1], val[2]));
                mp.put(val[0], temp);
            }

            if (!mp.containsKey(val[1])) {
                ArrayList<Pair> temp = new ArrayList<>();
                temp.add(new Pair(val[0], val[2]));
                mp.put(val[1], temp);

            } else {
                ArrayList<Pair> temp = mp.get(val[1]);
                temp.add(new Pair(val[0], val[2]));
                mp.put(val[1], temp);
            }

        }
        Queue<ArrayList<Pair>> q = new LinkedList<>();
        q.add(mp.get(1));
        while (q.size() > 0) {
            // System.out.println(q.size() + " size");
            int size = q.size();
            while (size-- > 0) {
                ArrayList<Pair> temp2 = q.remove();
                // System.out.println(temp2.size() + " ");
                for (int i = 0; i < temp2.size(); i++) {
                    if (!visited[temp2.get(i).x] && mp.get(temp2.get(i).x) != null) {
                        q.add(mp.get(temp2.get(i).x));
                        visited[temp2.get(i).x] = true;
                    }
                    min = Math.min(min, temp2.get(i).y);
                    // if( == n){
                    // return min;
                    // }
                }
            }
        }

        return min;
    }

    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}