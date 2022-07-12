class Solution {
public:
    bool isMatch(string s, string p) {
        bool dp[p.size() + 1][s.size() + 1];
        
        for(int i = p.size(); i >= 0; i--) {
            for(int j = s.size(); j >= 0; j--) {
                 if(i == p.size()&& j == s.size()) {
                     dp[i][j] = true;
                 }
                 else if(i == p.size()) {
                       dp[i][j] = false;
                 }
                 else if(j == s.size()) {
                       if(p[i] == '*') {
                             dp[i][j] = dp[i+1][j];
                       }
                     else {
                         dp[i][j] = false;
                     }
                 }
                 else {
                     if(p[i] == '*') {
                         dp[i][j] = dp[i+1][j] || dp[i][j+1];
                     }
                     else if(p[i] == '?') {
                         dp[i][j] = dp[i+1][j+1];
                     }
                     else {
                         if(p[i] == s[j]) dp[i][j] = dp[i+1][j+1];
                         else dp[i][j] = false;
                     }
                 }
            }
        }
        return dp[0][0];
    }
};