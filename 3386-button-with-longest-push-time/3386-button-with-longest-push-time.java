class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int maxnum = events[0][1]
            , maxind = events[0][0];
        for(int i = 1 ; i < events.length; i++){
            int dif = events[i][1] - events[i-1][1];
            if(dif == maxnum && maxind>events[i][0]){
                maxind = events[i][0];
            }
            if(dif > maxnum ){
                maxnum = dif;
                maxind = events[i][0];
            }
        }
        
        return maxind;
        
        
    }
}