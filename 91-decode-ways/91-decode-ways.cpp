class Solution {
public:
	
	int answer = 0;
	
	int dfs(vector<int>& dp, string& s, int i) {
		// This will be our base
		if (i == s.size())
			return 1;
		
		// -1 means unvisited, so if the value is not -1 we return dp[i]
		if (dp[i] > -1)
			return dp[i];
		
		int c1 = -48 + s[i];
		// If our current character is zero, we call it quit because there is no character code start with zero
		if (!c1) {
			dp[i] = 0;
			return 0;
		}
		
		// Do dfs for character 'a' to 'i'
		int count = 0;
		count += dfs(dp, s, i + 1);
		
		// Do dfs for character 'j' to 'z'; Remember, j is mapped 10
		if (i + 1 < s.size()) {
			int c2 = -48 + s[i + 1];
			if (c1 == 1 || (c1 == 2 && c2 <= 6)) {
				count += dfs(dp, s, i + 2);
			}
		}
		
		dp[i] = count;
		return count;
	}
	
	int numDecodings(string s) {
		// We will make all dp -1 to mark unvisited
		vector<int> dp(s.size(), -1);
		
		return dfs(dp, s, 0);
	}
};