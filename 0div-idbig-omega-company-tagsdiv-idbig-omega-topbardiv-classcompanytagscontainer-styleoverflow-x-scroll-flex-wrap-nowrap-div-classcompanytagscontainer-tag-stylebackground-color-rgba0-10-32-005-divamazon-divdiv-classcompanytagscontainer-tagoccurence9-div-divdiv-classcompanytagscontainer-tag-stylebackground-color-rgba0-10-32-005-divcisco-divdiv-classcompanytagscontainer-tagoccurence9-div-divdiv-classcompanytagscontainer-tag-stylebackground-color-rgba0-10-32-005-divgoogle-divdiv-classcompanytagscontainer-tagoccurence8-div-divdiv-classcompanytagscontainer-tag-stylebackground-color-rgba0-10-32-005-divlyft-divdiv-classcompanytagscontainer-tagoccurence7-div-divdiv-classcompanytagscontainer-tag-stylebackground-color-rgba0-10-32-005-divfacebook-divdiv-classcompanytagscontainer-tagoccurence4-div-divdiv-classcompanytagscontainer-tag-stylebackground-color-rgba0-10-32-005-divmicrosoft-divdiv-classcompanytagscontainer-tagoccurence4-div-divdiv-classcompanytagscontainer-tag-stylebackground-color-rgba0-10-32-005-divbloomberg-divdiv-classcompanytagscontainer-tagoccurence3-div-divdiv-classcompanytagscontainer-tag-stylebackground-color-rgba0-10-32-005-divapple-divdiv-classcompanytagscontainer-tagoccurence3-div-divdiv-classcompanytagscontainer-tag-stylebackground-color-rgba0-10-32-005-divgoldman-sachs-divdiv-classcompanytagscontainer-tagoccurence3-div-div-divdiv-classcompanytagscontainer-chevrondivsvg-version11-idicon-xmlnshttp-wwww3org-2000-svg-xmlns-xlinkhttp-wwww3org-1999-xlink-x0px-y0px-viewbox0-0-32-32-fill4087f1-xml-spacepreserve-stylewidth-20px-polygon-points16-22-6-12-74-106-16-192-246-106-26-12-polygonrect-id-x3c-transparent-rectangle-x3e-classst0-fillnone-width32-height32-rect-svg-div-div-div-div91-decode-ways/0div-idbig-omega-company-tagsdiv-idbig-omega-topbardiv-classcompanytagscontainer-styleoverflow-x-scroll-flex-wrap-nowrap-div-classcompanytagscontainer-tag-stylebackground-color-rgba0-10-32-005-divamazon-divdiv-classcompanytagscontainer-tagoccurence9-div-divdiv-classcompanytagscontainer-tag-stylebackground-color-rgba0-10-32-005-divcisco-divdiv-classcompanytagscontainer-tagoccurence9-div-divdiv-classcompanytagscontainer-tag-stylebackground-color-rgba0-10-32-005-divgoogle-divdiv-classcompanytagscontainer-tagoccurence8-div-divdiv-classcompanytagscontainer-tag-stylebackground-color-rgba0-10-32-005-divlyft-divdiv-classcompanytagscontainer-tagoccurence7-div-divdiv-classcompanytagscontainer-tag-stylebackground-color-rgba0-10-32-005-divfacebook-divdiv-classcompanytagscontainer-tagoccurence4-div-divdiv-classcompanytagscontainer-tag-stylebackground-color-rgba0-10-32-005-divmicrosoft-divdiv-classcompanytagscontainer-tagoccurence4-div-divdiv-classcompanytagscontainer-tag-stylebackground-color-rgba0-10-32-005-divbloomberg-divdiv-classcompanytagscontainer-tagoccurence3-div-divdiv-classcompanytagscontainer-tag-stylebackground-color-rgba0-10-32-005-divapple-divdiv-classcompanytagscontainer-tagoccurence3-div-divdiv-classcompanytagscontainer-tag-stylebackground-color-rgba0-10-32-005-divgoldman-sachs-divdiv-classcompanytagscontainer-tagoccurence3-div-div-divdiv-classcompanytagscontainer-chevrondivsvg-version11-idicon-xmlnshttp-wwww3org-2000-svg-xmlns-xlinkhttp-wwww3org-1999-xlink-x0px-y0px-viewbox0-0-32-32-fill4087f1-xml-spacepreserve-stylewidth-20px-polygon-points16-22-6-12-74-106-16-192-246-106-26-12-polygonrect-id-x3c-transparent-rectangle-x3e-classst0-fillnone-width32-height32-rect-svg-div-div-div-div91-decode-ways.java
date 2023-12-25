class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, 0, dp);
    }

    public int helper(String s,int i, int[] dp){
        if(s.length() == 0){
            return 1;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        if(s.charAt(0) == '0'){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }

        int single = helper(s.substring(1), i+1, dp);
        int doubl = 0;
        if(s.length()>=2){
            String sub = s.substring(0,2);
            int k = Integer.parseInt(sub);
            if(k <= 26){
                doubl = helper(s.substring(2), i+2, dp);
            }
        }
        dp[i] =  single + doubl;
        return dp[i];
    }
}