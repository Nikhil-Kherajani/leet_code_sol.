class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        int n = s.length();
        long totalCost = 0;

        for (int i = 0; i < n; i++) {
            int sChar = s.charAt(i) - 'a';
            int tChar = t.charAt(i) - 'a';

            if (sChar == tChar) {
                continue;
            }

            long forwardCost = 0;
            long backwardCost = 0;

            // Calculate forward cost
            int current = sChar;
            while (current != tChar) {
                forwardCost += nextCost[current];
                current = (current + 1) % 26;
            }

            // Calculate backward cost
            current = sChar;
            while (current != tChar) {
                backwardCost += previousCost[current];
                current = (current + 25) % 26; // Equivalent to moving back one step
            }

            totalCost += Math.min(forwardCost, backwardCost);
        }

        return totalCost;
    }
}