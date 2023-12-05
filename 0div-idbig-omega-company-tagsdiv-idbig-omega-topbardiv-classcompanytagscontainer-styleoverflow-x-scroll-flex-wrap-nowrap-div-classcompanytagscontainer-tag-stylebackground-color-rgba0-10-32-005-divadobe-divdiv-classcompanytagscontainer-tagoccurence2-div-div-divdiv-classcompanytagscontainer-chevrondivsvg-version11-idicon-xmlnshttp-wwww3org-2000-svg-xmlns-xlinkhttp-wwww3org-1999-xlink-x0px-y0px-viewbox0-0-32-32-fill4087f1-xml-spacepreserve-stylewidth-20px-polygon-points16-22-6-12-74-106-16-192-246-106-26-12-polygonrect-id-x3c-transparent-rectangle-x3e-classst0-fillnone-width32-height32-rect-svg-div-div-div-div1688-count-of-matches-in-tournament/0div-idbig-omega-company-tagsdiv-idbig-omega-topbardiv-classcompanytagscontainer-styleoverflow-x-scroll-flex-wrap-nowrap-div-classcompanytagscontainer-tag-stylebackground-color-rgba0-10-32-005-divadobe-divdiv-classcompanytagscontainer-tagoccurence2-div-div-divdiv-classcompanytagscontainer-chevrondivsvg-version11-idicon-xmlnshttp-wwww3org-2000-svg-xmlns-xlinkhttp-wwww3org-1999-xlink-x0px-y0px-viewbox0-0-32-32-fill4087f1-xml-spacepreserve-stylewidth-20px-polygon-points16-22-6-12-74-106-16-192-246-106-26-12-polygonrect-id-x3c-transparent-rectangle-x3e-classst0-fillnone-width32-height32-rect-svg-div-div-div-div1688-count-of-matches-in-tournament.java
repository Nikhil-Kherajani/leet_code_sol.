class Solution {
    public int numberOfMatches(int n) {
        int match = 0,unplayed = 0;
        while(n >= 1){
            if(n % 2 == 0){   
                    n/=2;
                    match += n; // saving matches
            }
            else{
                if(unplayed == 1){ /* prevous unplayed team need to be considered */
                    n += unplayed; // adding unplayed team to pool
                    n/=2;
                    match += n; // saving matches
                    unplayed = 0; // all team played now
                }
                else{
                    unplayed = 1; // 1 team enter next round
                    n/=2;
                    match += n; // saving matches
                }
            }
        }
        return match;
    }
}