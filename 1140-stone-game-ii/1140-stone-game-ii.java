class Solution {

    public int stoneGameII(int[] piles) {

        int[] postSum = new int[piles.length];
        Map<String,Integer> cache = new HashMap();
        
        //Calculate postFix sum
        postSum[piles.length-1] = piles[piles.length-1];
        for(int i=piles.length-2;i>=0;i--){
            postSum[i] = postSum[i+1]+piles[i];
        }
        
        int res = maxPiles(piles,0,1,postSum, cache);
        
        return (res+postSum[0])/2;
    }
    

    private int maxPiles(int[] piles, int start, int m, int[] postSum, Map<String,Integer> cache){
        /*
            Say we have 3 stones left, but the player could pick 8 in that round, he would obviously choose all 
            3 to maximise his score. 
            So here range is number of stones left and x is the number of stones he can pick in this round. 
        */
        if(cache.containsKey(start+","+m))
            return cache.get(start+","+m);
        int x = 2*m;
        int range = piles.length-start;
        if(range<=x){
             return postSum[start];   
        }
        
        /*
            important we CANNOT assign 0 to res because the difference of max(Alice) and max(Bob) can be a 
            negative value.
        */
        int res = Integer.MIN_VALUE;
        
        //loop through the possible choice of (stones to pick) and maximise the chances of winning for either 
        //player.
        for(int i=1;i<=x;i++){
            int sum = postSum[start] - postSum[start+i];
            res = Math.max(res, sum - maxPiles(piles, start+i, Math.max(i,m), postSum, cache));
        }
        cache.put(start+","+m,res);
        return cache.get(start+","+m);
    }
}