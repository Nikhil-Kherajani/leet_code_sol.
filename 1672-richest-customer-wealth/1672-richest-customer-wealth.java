class Solution {
    public int maximumWealth(int[][] accounts) {
        //To get size of rows and cols
        int rows=accounts.length;
        int cols=accounts[0].length;
        //Temporay var
        int max=Integer.MIN_VALUE;
        //store largest value
        int sum;
        
        for(int i=0;i<rows;i++){
            sum=0;
            for(int j=0;j<cols;j++){
                sum+=accounts[i][j];
            }
            if(sum>max)
                max=sum;   
        }
        return max;  
    }
}