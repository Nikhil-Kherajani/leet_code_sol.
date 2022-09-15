class Solution {
    
    int[][] grid;
    
    public int[][] largestLocal(int[][] grid) {
        this.grid = grid;
        
		// limit the rows and cols that can be checked
        int rows = grid.length - 2;
        int cols = grid[0].length - 2;
        
        int[][] local = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                local[i][j] = findMax(i, j);
            }
        }
        
        return local;
    }
    
	// find the max in 3x3 grid
    public int findMax(int x, int y) {
        int max = 0;
        int rows = x + 3;
        int cols = y + 3;
        
        for (int i = x; i < rows; i++) {
            for (int j = y; j < cols; j++) {
                if (grid[i][j] > max) max = grid[i][j];
            }
        }
        
        return max;
    }
}