class Solution {
    Integer[] cache;
    
    public String stoneGameIII(int[] piles) {
        int n = piles.length;
        
        cache = new Integer[n + 1];
        
        //AliceScore = Stone Collected by Alice - Stone Collected by Bob
        int AliceScore = getAliceScore(piles, 0);
        
        if(AliceScore > 0) return "Alice";
        
        if(AliceScore < 0) return "Bob";
        
        return "Tie";
    }
    
    private int getAliceScore(int[] piles, int index){
        if(index == piles.length) return 0;
        
        //reterive from cache
        if(cache[index] != null) return cache[index];
        
        int maxScore = Integer.MIN_VALUE;
        
        int stone = 0;
        
        for(int x = 0; x < 3; x++){
            int i = index + x;
            
            //ignore the invalid index
            if(i >= piles.length) continue;
            
            stone += piles[i];

            //calculate score
            int score = stone - getAliceScore(piles, i + 1);
            
            //update score
            maxScore = Math.max(maxScore, score);
        }
        
        //save in cache
        return cache[index] = maxScore;
    }
    
    
}