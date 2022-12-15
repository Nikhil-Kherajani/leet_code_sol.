class Solution {
    int dp[][]=new int[1000+1][1000+1] ;
    public  int maxsub(String a,String b, int i,int j){
        if( i>=a.length() || j>=b.length()) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        if( a.charAt(i)==b.charAt(j)) return dp[i][j]=1+maxsub(a,b,i+1,j+1);
        
        else {
            return dp[i][j]=Math.max( maxsub(a,b,i+1,j)  , maxsub(a,b,i,j+1));
        }
    }
    public int longestCommonSubsequence(String a, String b) {
        for (int[] row: dp)
            Arrays.fill(row, -1);
        
        return maxsub(a,b,0,0);
    }
};