class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        final int n = gain.length;
        int ch = 0;
        for(int i = 0 ; i < n ; i++){
            ch = ch + gain[i];
            max = Math.max(max , ch);
        }
        return max;
    }
}