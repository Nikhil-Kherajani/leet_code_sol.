class Solution {
    public int countOdds(int low, int high) {
        if(low % 2 != 0 || high % 2 != 0){
            return (int)Math.ceil((high - low + 1)*1d/2);
        }
        else
            return (int)Math.floor((high - low + 1)*1d/2);
    }
}