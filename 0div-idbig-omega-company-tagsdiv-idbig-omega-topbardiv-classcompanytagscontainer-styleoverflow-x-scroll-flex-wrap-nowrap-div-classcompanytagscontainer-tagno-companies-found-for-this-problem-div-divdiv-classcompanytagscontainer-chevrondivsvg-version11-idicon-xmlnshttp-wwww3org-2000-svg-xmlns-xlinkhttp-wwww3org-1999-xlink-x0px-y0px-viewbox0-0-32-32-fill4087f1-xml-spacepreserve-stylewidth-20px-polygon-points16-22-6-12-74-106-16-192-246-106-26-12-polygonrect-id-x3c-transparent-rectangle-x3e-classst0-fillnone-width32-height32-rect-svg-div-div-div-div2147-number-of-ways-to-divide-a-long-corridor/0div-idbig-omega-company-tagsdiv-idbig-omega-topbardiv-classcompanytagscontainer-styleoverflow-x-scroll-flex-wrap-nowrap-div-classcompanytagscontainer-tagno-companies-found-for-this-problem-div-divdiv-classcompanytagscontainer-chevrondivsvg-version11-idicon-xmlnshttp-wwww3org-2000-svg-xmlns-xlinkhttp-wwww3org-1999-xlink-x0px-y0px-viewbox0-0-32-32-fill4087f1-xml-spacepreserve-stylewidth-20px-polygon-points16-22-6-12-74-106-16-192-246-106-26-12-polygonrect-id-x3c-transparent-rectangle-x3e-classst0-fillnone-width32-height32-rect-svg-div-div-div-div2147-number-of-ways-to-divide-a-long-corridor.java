class Solution {
    public int numberOfWays(String corridor) {
        // Store 1000000007 in a variable for convenience
        final int MOD = 1_000_000_007;

        // Store indices of S in an array
        List<Integer> indices = new ArrayList<>();
        for (int index = 0; index < corridor.length(); index++) {
            if (corridor.charAt(index) == 'S') {
                indices.add(index);
            }
        }

        // When division is not possible
        if (indices.size() == 0 || indices.size() % 2 == 1) {
            return 0;
        }

        // Total number of ways
        long count = 1;

        // Take product of non-paired neighbors
        int previousPairLast = 1;
        int currentPairFirst = 2;
        while (currentPairFirst < indices.size()) {
            count *= (indices.get(currentPairFirst) - indices.get(previousPairLast));
            count %= MOD;
            previousPairLast += 2;
            currentPairFirst += 2;
        }

        // Return the number of ways
        return (int) count;
    }
}