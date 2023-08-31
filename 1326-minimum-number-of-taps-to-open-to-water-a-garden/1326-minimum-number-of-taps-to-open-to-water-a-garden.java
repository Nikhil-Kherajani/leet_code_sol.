class Solution {
    public int minTaps(int n, int[] ranges) {
        // Create an array to track the maximum reach for each position
        int[] maxReach = new int[n + 1];

        // Calculate the maximum reach for each tap
        for (int i = 0; i < ranges.length; i++) {
            // Calculate the leftmost position the tap can reach
            int start = Math.max(0, i - ranges[i]);
            // Calculate the rightmost position the tap can reach
            int end = Math.min(n, i + ranges[i]);

            // Update the maximum reach for the leftmost position
            maxReach[start] = Math.max(maxReach[start], end);
        }
        
        // Number of taps used
        int taps = 0;
        // Current rightmost position reached
        int currEnd = 0;
        // Next rightmost position that can be reached
        int nextEnd = 0;

        // Iterate through the garden
        for (int i = 0; i <= n; i++) {
            // Current position cannot be reached
            if (i > nextEnd) {
                return -1;
            }

            // Increment taps when moving to a new tap
            if (i > currEnd) {
                taps++;
                // Move to the rightmost position that can be reached
                currEnd = nextEnd;
            }

            // Update the next rightmost position that can be reached
            nextEnd = Math.max(nextEnd, maxReach[i]);
        }

        // Return the minimum number of taps used
        return taps;
    }
}