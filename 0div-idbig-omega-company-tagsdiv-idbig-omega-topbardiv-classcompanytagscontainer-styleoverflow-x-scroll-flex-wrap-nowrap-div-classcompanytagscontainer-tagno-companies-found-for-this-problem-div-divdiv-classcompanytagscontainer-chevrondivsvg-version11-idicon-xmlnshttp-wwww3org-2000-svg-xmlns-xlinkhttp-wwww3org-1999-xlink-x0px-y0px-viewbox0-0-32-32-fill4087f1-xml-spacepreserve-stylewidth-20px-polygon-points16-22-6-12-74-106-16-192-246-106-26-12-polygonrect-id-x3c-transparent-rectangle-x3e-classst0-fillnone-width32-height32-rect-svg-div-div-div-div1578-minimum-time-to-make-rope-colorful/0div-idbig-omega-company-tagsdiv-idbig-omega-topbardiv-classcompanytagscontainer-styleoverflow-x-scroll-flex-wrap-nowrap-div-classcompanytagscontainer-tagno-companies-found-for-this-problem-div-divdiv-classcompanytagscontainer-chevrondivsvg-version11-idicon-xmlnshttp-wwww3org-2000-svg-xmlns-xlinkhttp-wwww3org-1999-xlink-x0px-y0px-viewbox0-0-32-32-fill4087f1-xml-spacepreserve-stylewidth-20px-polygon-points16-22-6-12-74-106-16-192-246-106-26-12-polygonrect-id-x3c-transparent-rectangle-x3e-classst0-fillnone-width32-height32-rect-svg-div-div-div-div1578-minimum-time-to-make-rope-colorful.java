class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        char prevColor = colors.charAt(0);
        int prevTime = neededTime[0];
        int totalTime = 0;
        for(int i=1; i<n; i++){
            char currColor = colors.charAt(i);
            int currTime = neededTime[i];
            if(currColor == prevColor){
                if(prevTime < currTime){
                    totalTime += prevTime;
                    prevTime = currTime;
                }
                else{
                    totalTime += currTime;                    
                }
            }
            else{
                prevColor = currColor;
                prevTime = currTime;
            }
        } 
        return totalTime;
    }
}
