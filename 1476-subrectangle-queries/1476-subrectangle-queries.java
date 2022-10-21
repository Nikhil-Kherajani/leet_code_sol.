class SubrectangleQueries {
    int[][] rect;
    ArrayList<int[]> updates;
    public SubrectangleQueries(int[][] rectangle) {
        rect = rectangle;
        updates = new ArrayList<>();
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
           updates.add(new int[]{row1, col1, row2, col2, newValue});
    }
    
    public int getValue(int row, int col) {
        int response = rect[row][col];
        for(int[] arr: updates) {
            int row1 = arr[0], col1 = arr[1], row2 = arr[2], col2 = arr[3], newValue = arr[4];
            if(row >= row1 && row <= row2 && col >= col1 && col <= col2) {
                response = newValue;
            }
        }
        return response;
    }
}
