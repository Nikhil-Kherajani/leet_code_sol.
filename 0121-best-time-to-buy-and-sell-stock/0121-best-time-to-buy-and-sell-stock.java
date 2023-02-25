class Solution {
    
    public int maxProfit(int[] prices) {
        int n = prices.length ;
        int least = prices[0] ;
        int max = -64;
        
        for(int i = 1 ; i < n ; i++){
            if(prices[i] < least){
                least = prices[i];
            }
            else{
                if(prices[i] - least > max){
                    max = prices[i] - least;
                }
            }
        }
        if(max == -64)
            return 0;
        // System.out.println(max);
        return max;
    }
}