class Solution {
    public int ways(String[] pizza, int k) {
        int MOD = 1_000_000_007;
        int row = pizza.length;
        int column = pizza[0].length();

        // appleCounts[i][j] is the amount of apples in the pizza rectangular (i,j) ~ (row - 1, column - 1)
        int[][] appleCounts = new int[row][column];

        // waysOfCutting[i][j][k] is the number of ways of cutting the pizza rectangular (i,j) ~ (row - 1, column - 1) into k pieces
        int[][][] waysOfCutting = new int[row][column][k + 1];

        // initiate appleCounts
        for(int i = row - 1; i >= 0; i --){
            for(int j = column - 1; j >= 0; j --){
                int appleInCurrentCell = pizza[i].charAt(j) == 'A'? 1 : 0;
                if(i != row - 1 && j != column - 1){
                    appleCounts[i][j] = appleInCurrentCell + appleCounts[i + 1][j] + appleCounts[i][j + 1] - appleCounts[i + 1][j + 1];
                }
                else if(i == row - 1 && j == column - 1){
                    appleCounts[i][j] = appleInCurrentCell;
                }
                else if(i == row - 1 && j != column - 1){
                    appleCounts[i][j] = appleInCurrentCell + appleCounts[i][j + 1];
                }
                else{ // if i != row - 1 && j == column - 1
                    appleCounts[i][j] = appleInCurrentCell + appleCounts[i + 1][j];
                }
            }
        }

        for(int i = row - 1; i >= 0; i --){
            for(int j = column - 1; j >= 0; j --){
                for(int piece = 1; piece <= k; piece ++){
                    if(appleCounts[i][j] == 0){
                        waysOfCutting[i][j][piece] = 0;
                        continue;
                    }
                    
                    if(piece == 1){
                        waysOfCutting[i][j][piece] = 1;
                        continue;
                    }
                    
                    // Cut horizontally
                    for(int cut = i + 1; cut < row; cut ++){
                        if(appleCounts[i][j] - appleCounts[cut][j] > 0){
                            waysOfCutting[i][j][piece] += waysOfCutting[cut][j][piece - 1];
                            waysOfCutting[i][j][piece] %= MOD;
                        }
                    }

                    // Cut vertically
                    for(int cut = j + 1; cut < column; cut ++){
                        if(appleCounts[i][j] - appleCounts[i][cut] > 0){
                            waysOfCutting[i][j][piece] += waysOfCutting[i][cut][piece - 1];
                            waysOfCutting[i][j][piece] %= MOD;
                        }
                    }
                }
            }
        }

        return waysOfCutting[0][0][k];
    }
}