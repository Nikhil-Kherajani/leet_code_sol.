class Solution {
    public int numSquares(int n) {
        int [] squares = new int[(int)Math.sqrt(n)];
        for(int i=0;i<squares.length;i++){
            squares[i]=(i+1)*(i+1);
        }
        int [][] dp = new int [(int)Math.sqrt(n)][n+1];
        for(int i=0;i<n+1;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<(int)Math.sqrt(n);i++){
            for(int j=0;j<n+1;j++){
                if(j-squares[i]>=0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-squares[i]]+1);
                }
                else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[(int)Math.sqrt(n)-1][n];
    }

}