class Solution {
    public boolean checkValidGrid(int[][] grid) {
        final int n = grid.length;
        if(n == 3 || grid[0][0] != 0){
            return false;
        }
        Pair[] arr = new Pair[n * n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[grid[i][j]] = new Pair(i , j);
            }
        }
        for(int i = 0 ; i < n*n - 1; i++){
            int dif = Math.abs(arr[i].x - arr[i+1].x) + Math.abs(arr[i].y - arr[i+1].y);
            if(dif != 3){
                return false;
            }
        }
        return true;
    }
    
    
}
class Pair{
        int x , y;
        Pair(int x , int y){
            this.x = x;
            this.y = y;
        }
    }