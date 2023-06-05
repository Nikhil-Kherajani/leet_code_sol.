class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int y = coordinates[0][1] , x = coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1], dx = coordinates[1][0] - coordinates[0][0];
        for(int i = 2 ; i < coordinates.length ; i++){
            if(dy*(coordinates[i][0] - x) != dx*(coordinates[i][1] -y)){
                return false;
            }
        }
        return true;
    }
}