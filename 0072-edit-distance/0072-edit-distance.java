class Solution {
    public int minDistance(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();

        if (word1Length == 0) {
            return word2Length;
        }
        if (word2Length == 0) {
            return word1Length;
        }

        int dp[][] = new int[word1Length + 1][word2Length + 1];

        for (int word1Index = 1; word1Index <= word1Length; word1Index++) {
            dp[word1Index][0] = word1Index;
        }

        for (int word2Index = 1; word2Index <= word2Length; word2Index++) {
            dp[0][word2Index] = word2Index;
        }

        for (int word1Index = 1; word1Index <= word1Length; word1Index++) {
            for (int word2Index = 1; word2Index <= word2Length; word2Index++) {
                if (word2.charAt(word2Index - 1) == word1.charAt(word1Index - 1)) {
                    dp[word1Index][word2Index] = dp[word1Index - 1][word2Index - 1];
                } else {
                    dp[word1Index][word2Index] = Math.min(dp[word1Index - 1][word2Index],
                            Math.min(dp[word1Index][word2Index - 1],
                                    dp[word1Index - 1][word2Index - 1])) + 1;
                }
            }
        }

        return dp[word1Length][word2Length];
    }
}