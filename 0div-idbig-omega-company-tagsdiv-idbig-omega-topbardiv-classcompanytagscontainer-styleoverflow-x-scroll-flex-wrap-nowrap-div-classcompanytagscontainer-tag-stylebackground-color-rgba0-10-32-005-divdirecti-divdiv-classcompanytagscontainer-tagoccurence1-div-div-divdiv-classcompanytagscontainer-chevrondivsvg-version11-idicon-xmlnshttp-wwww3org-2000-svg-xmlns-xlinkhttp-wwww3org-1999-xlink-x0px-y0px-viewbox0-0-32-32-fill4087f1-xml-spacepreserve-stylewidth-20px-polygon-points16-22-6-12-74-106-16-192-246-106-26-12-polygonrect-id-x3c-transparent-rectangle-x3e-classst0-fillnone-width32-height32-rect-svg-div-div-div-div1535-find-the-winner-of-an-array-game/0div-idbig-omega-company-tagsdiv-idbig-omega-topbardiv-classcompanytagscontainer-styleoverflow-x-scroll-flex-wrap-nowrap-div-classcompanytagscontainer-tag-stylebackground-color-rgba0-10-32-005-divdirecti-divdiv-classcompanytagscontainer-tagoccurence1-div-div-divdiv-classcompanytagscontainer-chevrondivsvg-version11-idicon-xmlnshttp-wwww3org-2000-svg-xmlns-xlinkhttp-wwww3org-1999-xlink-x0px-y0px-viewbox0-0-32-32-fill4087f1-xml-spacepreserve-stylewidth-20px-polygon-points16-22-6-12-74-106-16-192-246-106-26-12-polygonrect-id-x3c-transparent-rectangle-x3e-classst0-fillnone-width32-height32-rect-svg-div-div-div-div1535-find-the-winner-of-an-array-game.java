class Solution {
    public int getWinner(int[] arr, int k) {
        int maxElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxElement = Math.max(maxElement, arr[i]);
        }
        
        int curr = arr[0];
        int winstreak = 0;
        
        for (int i = 1; i < arr.length; i++) {
            int opponent = arr[i];
            
            if (curr > opponent) {
                winstreak++;
            } else {
                curr = opponent;
                winstreak = 1;
            }
            
            if (winstreak == k || curr == maxElement) {
                return curr;
            }
        }
        
        return -1;
    }
}