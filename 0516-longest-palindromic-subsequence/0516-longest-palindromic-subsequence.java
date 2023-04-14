class Solution {
    public int longestPalindromeSubseq(String s) {
	int[] dp = new int[s.length()];
	for (int i = s.length() - 1; i >= 0; i--) {
		dp[i] = 1;
		int pre = 0;
		for (int j = i + 1; j < s.length(); j++) {
			int tmp = dp[j];
			if (s.charAt(i) == s.charAt(j)) {
				dp[j] = pre + 2;
			} else {
				dp[j] = Math.max(dp[j], dp[j - 1]);
			}
			pre = tmp;
		}
	}

	return dp[s.length() - 1];
}
}