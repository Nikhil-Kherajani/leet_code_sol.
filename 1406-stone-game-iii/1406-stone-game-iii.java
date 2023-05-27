class Solution {
    Integer[] cache;
    
    public String stoneGameIII(int[] piles) {
        int n = piles.length;
        
        cache = new Integer[n + 1];
        
        int AliceScore = getAliceScore(piles, 0);
        
        if(AliceScore > 0) return "Alice";
        
        if(AliceScore < 0) return "Bob";
        
        return "Tie";
    }
    
    private int getAliceScore(int[] piles, int index){
        if(index == piles.length) return 0;
        
        if(cache[index] != null) return cache[index];
        
        int maxScore = Integer.MIN_VALUE;
        
        int stone = 0;
        
        for(int x = 0; x < 3; x++){
            int i = index + x;
            
            if(i >= piles.length) continue;
            
            stone += piles[i];

            int score = stone - getAliceScore(piles, i + 1);
            
            maxScore = Math.max(maxScore, score);
        }
        
        return cache[index] = maxScore;
    }
    
    
}