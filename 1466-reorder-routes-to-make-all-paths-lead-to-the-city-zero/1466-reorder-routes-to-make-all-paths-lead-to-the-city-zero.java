class Solution {
    public int minReorder(int n, int[][] connections) {
        ArrayList<Pair>[] roads = new ArrayList[n];
        boolean[] visited = new boolean[n];
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            roads[i] = new ArrayList<Pair>();
        }
        for(int[] val : connections){
            roads[val[0]].add(new Pair(val[1] , 'o'));
            roads[val[1]].add(new Pair(val[0] , 'i'));            
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while(q.size() > 0){
            int cur = q.remove();
            for(int i = 0 ; i < roads[cur].size() ; i++ ){
                if(!visited[roads[cur].get(i).x]){
                    if(roads[cur].get(i).y == 'o'){
                        ans++;
                    }
                    q.add(roads[cur].get(i).x);
                    visited[roads[cur].get(i).x] = true;
                }
            }
        }
        return ans;
    }
    
    class Pair{
        int x;
        char y;
        Pair(int x , char y){
            this.x= x;
            this.y = y;
        }
    }
}