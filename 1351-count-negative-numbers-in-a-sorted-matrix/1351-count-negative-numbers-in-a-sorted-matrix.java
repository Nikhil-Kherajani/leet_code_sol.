class Solution {
    public int countNegatives(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int j=m-1;
        int s=0;
        for(int i=0;i<n;i++)
        {
                while(j>=0 && grid[i][j]<0)
                    j--;

                s+=(m-j-1);
        }
        return s;
    }
}