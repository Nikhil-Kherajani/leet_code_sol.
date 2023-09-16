class Solution {
    Map<String,List<int[]>> map = new HashMap<>();
    int[] dir = {1,0,-1,0,1};
    int end = 0;
    int n = 0;
    int m = 0;
    private boolean isPossible(int k){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        while(queue.size() > 0){
            int[] top = queue.poll();
            int i = top[0];
            int j = top[1];
            if(i == n - 1 && j == m - 1){
                return true;
            }

            for(int[] nei : map.get(i + " - " + j)){
                if(nei[2] <= k && !visited[nei[0]][nei[1]]){
                    visited[nei[0]][nei[1]] = true;
                    queue.offer(new int[]{nei[0],nei[1]});
                }
            }
        }

        return false;
    }
    private void addNeightbours(int[][] a,int i,int j){
        
        for(int k = 0;k < 4;k++){
            int ni = i + dir[k];
            int nj = j + dir[k + 1];
            if(ni < n && ni >= 0 && nj < m && nj >= 0){
                end = Math.max(end,Math.abs(a[i][j] - a[ni][nj]));
                map.get(i + " - " + j).add(new int[]{ni,nj,Math.abs(a[i][j] - a[ni][nj])});
            }
        }
    }
    public int minimumEffortPath(int[][] a) {
        n = a.length;
        m = a[0].length;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                map.put(i + " - " + j,new ArrayList<>());
                addNeightbours(a,i,j);
            }
        }

        int start = 0;
        int ans = 0;
        while(start <= end){
            int mid = (end + start) / 2;
            if(isPossible(mid)){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return ans;
    }
}